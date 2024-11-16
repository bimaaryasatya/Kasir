/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LogSaver {
    static String folder = ".kelasC";
    static String home = "C:\\Users\\bimazznxt\\Desktop";
    static String pathFolder = home + File.separator + folder;
    
    static String logName = "Log.txt";
    static String pathLog = pathFolder + File.separator + logName;
    
    public static void saveLog(String text) {
        try {
            File f = new File(pathFolder);
            if (!f.exists()) {
                boolean dirCreated = f.mkdir();
                if (dirCreated) {
                    System.out.println("Folder Berhasil Dibuat: " + pathFolder);
                } else {
                    System.out.println("Gagal Membuat Folder: " + pathFolder);
                }
            }
            
            File log = new File(pathLog);
            if (!log.exists()) {
                boolean fileCreated = log.createNewFile();
                if (fileCreated) {
                    System.out.println("Log File Berhasil Dibuat: " + pathLog);
                } else {
                    System.out.println("Gagal Membuat Log File: " + pathLog);
                }
            }
            
            Files.write(
                    Paths.get(pathLog), 
                    text.getBytes(), 
                    StandardOpenOption.APPEND);
            
        } catch (IOException e) {
            System.out.println("Error Code: 101 => " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        saveLog("Test Log\n");
        System.out.println("Log Entry Telah Disimpan");
    }
}
