package com.peng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author Linhaipeng
 * @Date 2024/3/6 20:26
 * @Version 1.0
 */

public class BackupScheduler {


    public void startScheduledBackup(String fileFolder, String backupFolder) throws InterruptedException {
        System.out.println("fileFolder："+fileFolder+"；backupFolder："+backupFolder);

        Timer t = new Timer();
        t.scheduleAtFixedRate(new MyTask(fileFolder,backupFolder),new Date(),1000*10);

        for(int i = 0;i<10000;i++){
            Thread.sleep(1000);
            System.out.println("warning");
        }
    }
}


class MyTask extends TimerTask {

    static String fileFolder;

    static String backupFolder;

    public MyTask(String fileFolder,String backupFolder){
        this.fileFolder=fileFolder;
        this.backupFolder=backupFolder;
    }

    @Override
    public void run() {

        Date d = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String backupFolderPath = backupFolder + "\\" + df.format(d);
        File dest = new File(backupFolderPath);

        if (dest.exists()) {
            deleteAll(dest);
        }
        System.out.println("创建备份目录？" + dest.mkdirs()+",,,,备份目录："+backupFolderPath);
        List<File> list = new ArrayList<>();
        getAllFile(new File(fileFolder), list);
        backUp(list, backupFolderPath);

        try {
            BackupInfoToDB.saveBackupFloderInfoToDB(fileFolder,backupFolderPath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //备份
    private static void backUp(List<File> list, String backupFolderPath) {

        if (list == null || list.size() <= 0) {
            return;
        }
        for (File f : list) {
            String fpath = f.getAbsolutePath();     //取出绝对路径
            System.out.println("绝对路径："+fpath);
            String newpath = fpath.replace(fileFolder, backupFolderPath);
            System.out.println("对应的新路径" + newpath);
            File newFile = new File(newpath);
            if (newFile.getParentFile().exists() == false) {

                System.out.println("创建" + newFile + "的父目录成功？" + newFile.getParentFile().mkdirs());
            }
            if (f.isFile()) {
                copy(f, newFile);
            }
        }

    }

    //复制
    private static void copy(File inFile, File outFile) {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        boolean isFlag = false;

        try {

            fis = new FileInputStream(inFile);
            fos = new FileOutputStream(outFile);

            byte[] bs = new byte[1024];
            int length = -1;
            while ((length = fis.read(bs)) != -1) {

                fos.write(bs, 0, length);
            }
            fos.flush();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            if (fos != null) {

                try {

                    fos.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
            if (fis != null) {

                try {

                    fis.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }
    }

    //递归获取原目录下所有的文件信息
    private static void getAllFile(File source, List<File> list) {

        if (source.isDirectory()) {

            //查看子目录 listFile()
            File[] fs = source.listFiles();
            if (fs != null && fs.length > 0) {
                //说明有子目录或子文件
                for (File ff : fs) {
                    getAllFile(ff, list);
                }
            }

        }
        list.add(source);

    }

    //递归删除
    private static void deleteAll(File f) {

        if (f.isDirectory()) {

            File[] fs = f.listFiles();
            if (fs != null && fs.length > 0) {

                for (File file : fs) {

                    deleteAll(file);
                }
            }
        }
        System.out.println(f + "删除成功？" + f.delete());
    }

}