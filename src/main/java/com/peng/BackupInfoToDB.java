package com.peng;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * @Author Linhaipeng
 * @Date 2024/3/6 11:10
 * @Version 1.0：备份数据保存到数据库中
 */

public class BackupInfoToDB {

    public static Connection connection;

    // 数据库信息
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/backup?useUnicode=true&characterEncoding=utf8";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "19720603";

    /**
     * @Description：将备份文件数据保存到数据库
     * @Param   backupFilePath：文件路径
     *          backupFolder：备份文件夹路径
     *          backupFileName：保存的备份文件名称
     * @Return
     */
    public static void saveBackupFileInfoToDB(String backupFilePath, String backupFolder, String backupFileName) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        String sql = "INSERT INTO backup_info (file_folder, file_name, backup_folder, backup_file_name, backup_time) VALUES (?, ?, ?, ?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, new File(backupFilePath).getParent());
            stmt.setString(2, new File(backupFilePath).getName());
            stmt.setString(3,backupFolder);
            stmt.setString(4, backupFileName);
            stmt.setTimestamp(5, new java.sql.Timestamp(new Date().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description：将备份文件夹数据保存到数据库
     * @Param   backupFilePath：文件路径
     *          backupFolder：备份文件夹路径
     * @Return
     */
    public static void saveBackupFloderInfoToDB(String backupFolderPath, String backupFolder) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        String sql = "INSERT INTO backup_info (file_folder, backup_folder, backup_time) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, backupFolderPath);
            stmt.setString(2,backupFolder);
            stmt.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
