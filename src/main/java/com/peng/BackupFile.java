package com.peng;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author Linhaipeng
 * @Date 2024/3/6 11:08
 * @Version 1.0：备份文件
 */

public class BackupFile {

    /**
     * @Description：备份文件
     * @Param：
     * @Return
     */
    public static boolean backupFile(String sourceFilePath, String targetDirectoryPath) {
        try {
            File sourceFile = new File(sourceFilePath);
            File targetFile = new File(targetDirectoryPath + File.separator + sourceFile.getName());

            int count = 2;
            String fileName = sourceFile.getName();
            String fileNameWithoutExtension = fileName.replaceFirst("[.][^.]+$", "");
            String fileExtension = fileName.substring(fileName.lastIndexOf("."));

            while (targetFile.exists()) {
                String newFileName = fileNameWithoutExtension + "-" + count + fileExtension;
                targetFile = new File(targetDirectoryPath + File.separator + newFileName);
                count++;
            }

            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(targetFile);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }

            fis.close();
            fos.close();

            BackupInfoToDB.saveBackupFileInfoToDB(sourceFilePath, targetDirectoryPath, new File(String.valueOf(targetFile)).getName());
            return true;

        } catch (IOException e) {
//            JOptionPane.showMessageDialog(this, "备份文件时出错: " + e.getMessage());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
