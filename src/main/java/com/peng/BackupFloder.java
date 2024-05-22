package com.peng;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

/**
 * @Author Linhaipeng
 * @Date 2024/3/6 11:08
 * @Version 1.0：备份文件夹到目标位置
 */

public class BackupFloder extends BackupFile {

    public static boolean backupFolder(String sourceFolderPath, String targetDirectoryPath) throws SQLException, ClassNotFoundException {
        File sourceFolder = new File(sourceFolderPath);
        File targetFolder = new File(targetDirectoryPath + File.separator + sourceFolder.getName());
        if (!targetFolder.exists()) {
            targetFolder.mkdirs();
        } else {
            int count = 2;
            while (targetFolder.exists()) {
                String newFolderName = targetDirectoryPath + File.separator + sourceFolder.getName() + "-" + count;
                targetFolder = new File(newFolderName);
                count++;
            }
            targetFolder.mkdirs();
        }

        System.out.println("sourceFolderPath：" + sourceFolderPath + ", targetDirectoryPath：" + targetDirectoryPath);

        File[] files = sourceFolder.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                File newFile = new File(targetFolder.getPath() + File.separator + file.getName());
                try {
                    Files.copy(file.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (file.isDirectory()) {
                backupFolder(file.getPath(), targetFolder.getPath());
            }
        }

        BackupInfoToDB.saveBackupFloderInfoToDB(sourceFolderPath, targetFolder.getPath());
        return true;
    }


}
