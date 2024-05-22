package com.peng;

/**
 * @Author Linhaipeng
 * @Date 2024/3/3 11:14
 * @Version 1.0
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FileBackupSystem extends JFrame {

    private JButton backupFileButton;
    private JButton backupFolderButton;
    private JButton choosePathButton;
    private JButton startBackupButton;

    private JLabel selectedFileLabel;
    private JLabel selectedFolderLabel;
    private JLabel selectedPathLabel;

    private String sourceFilePath="1";          //源文件路径
    private String sourceFolderPath="1";        //源文件夹路径
    private String targetDirectoryPath;         //备份目标文件夹路径
    private boolean isBackupFileSelected = true; // 默认选择备份文件

    private JButton schedulerFileFolderButton;
    private JButton schedulerBackupFolderButton;
    private JButton schedulerStartBackupButton;

    private JLabel schedulerFileFolderLabel;
    private JLabel schedulerBackupFolderLabel;

    private String schedulerFileFolderPath="1";
    private String schedulerBackupFolderPath="1";


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FileBackupSystem());
    }


    public FileBackupSystem() {
        setTitle("文件备份系统");
        setSize(380, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));

        // 选择文件按钮并监听
        backupFileButton = new JButton("选择文件");
        backupFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isBackupFileSelected = true;
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    sourceFilePath = fileChooser.getSelectedFile().getPath();
                    selectedFileLabel.setText("已选择文件: " + sourceFilePath);
                    JOptionPane.showMessageDialog(FileBackupSystem.this, "选择文件成功！已选择文件路径：" + sourceFilePath);
                }
            }
        });

        // 选择文件夹按钮并监听
        backupFolderButton = new JButton("选择文件夹");
        backupFolderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isBackupFileSelected = false;
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    sourceFolderPath = fileChooser.getSelectedFile().getPath();
                    selectedFolderLabel.setText("已选择文件夹: " + sourceFolderPath);
                    JOptionPane.showMessageDialog(FileBackupSystem.this, "选择文件夹成功！已选择文件夹路径：" + sourceFolderPath);
                }
            }
        });

        //选择备份路径按钮并监听
        choosePathButton = new JButton("选择备份路径");
        choosePathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    targetDirectoryPath = fileChooser.getSelectedFile().getPath();
                    selectedPathLabel.setText("备份路径: " + targetDirectoryPath);
                    JOptionPane.showMessageDialog(FileBackupSystem.this, "选择备份路径成功！备份路径：" + targetDirectoryPath);
                }
            }
        });

        //开始备份按钮并监听
        startBackupButton = new JButton("开始备份");
        startBackupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sourceFilePath != null && targetDirectoryPath != null) {

                    if(sourceFilePath.isEmpty() || sourceFolderPath.isEmpty()){
                        JOptionPane.showMessageDialog(FileBackupSystem.this, "请选择文件或者文件夹！");
                    }else if(targetDirectoryPath.isEmpty()){
                        JOptionPane.showMessageDialog(FileBackupSystem.this, "请选择备份目标路径！");
                    }else {


                        if (isBackupFileSelected) {
                            //备份文件
                            boolean result = BackupFile.backupFile(sourceFilePath, targetDirectoryPath);
                            if(result==true){
                                JOptionPane.showMessageDialog(FileBackupSystem.this, "文件备份成功!");
                            }else{
                                JOptionPane.showMessageDialog(FileBackupSystem.this, "文件备份失败!");
                            }
                        } else{
                            //备份文件夹
                            System.out.println("备份文件夹");
                            boolean result = false;
                            try {
                                result = BackupFloder.backupFolder(sourceFolderPath, targetDirectoryPath);
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            } catch (ClassNotFoundException classNotFoundException) {
                                classNotFoundException.printStackTrace();
                            }
                            if(result==true){
                                JOptionPane.showMessageDialog(FileBackupSystem.this, "文件夹备份成功!");
                            }else{
                                JOptionPane.showMessageDialog(FileBackupSystem.this, "文件夹备份失败!");
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(FileBackupSystem.this, "请选择文件/文件夹和备份路径!");
                }
            }
        });

        // 选择定时备份文件夹按钮并监听
        schedulerFileFolderButton = new JButton("选择定时备份文件夹");
        schedulerFileFolderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    schedulerFileFolderPath = fileChooser.getSelectedFile().getPath();
                    schedulerFileFolderLabel.setText("已选择文件夹: " + schedulerFileFolderPath);
                    JOptionPane.showMessageDialog(FileBackupSystem.this, "选择文件夹成功！已选择文件夹路径：" + schedulerFileFolderPath);
                }
            }
        });

        // 选择目标备份目录按钮并监听
        schedulerBackupFolderButton = new JButton("选择定时目标备份文件夹");
        schedulerBackupFolderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    schedulerBackupFolderPath = fileChooser.getSelectedFile().getPath();
                    schedulerBackupFolderLabel.setText("已选择文件夹: " + schedulerBackupFolderPath);
                    JOptionPane.showMessageDialog(FileBackupSystem.this, "选择文件夹成功！已选择文件夹路径：" + schedulerBackupFolderPath);
                }
            }
        });

        //开始定时备份按钮并监听
        schedulerStartBackupButton = new JButton("开始备份");
        schedulerStartBackupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(schedulerFileFolderPath.isEmpty()||schedulerBackupFolderPath.isEmpty()){
                    JOptionPane.showMessageDialog(FileBackupSystem.this, "请选择定时文件夹和备份文件目录！");
                }else{
                    startScheduledBackup();
                }
            }
        });

        selectedFileLabel = new JLabel("已选择文件: ");
        selectedFolderLabel =new JLabel("已选择文件夹：");
        selectedPathLabel = new JLabel("备份路径: ");

        schedulerFileFolderLabel=new JLabel("已选择文件夹（定时备份）：");
        schedulerBackupFolderLabel=new JLabel("已选择目标文件夹（定时备份）：");

        add(backupFileButton);
        add(backupFolderButton);
        add(choosePathButton);
        add(selectedFileLabel);
        add(selectedFolderLabel);
        add(selectedPathLabel);
        add(startBackupButton);

        add(schedulerFileFolderButton);
        add(schedulerBackupFolderButton);
        add(schedulerFileFolderLabel);
        add(schedulerBackupFolderLabel);
        add(schedulerStartBackupButton);

        setVisible(true);
    }

    private void startScheduledBackup() {

        BackupScheduler scheduler = new BackupScheduler();
        try {
            scheduler.startScheduledBackup(schedulerFileFolderPath, schedulerBackupFolderPath);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}