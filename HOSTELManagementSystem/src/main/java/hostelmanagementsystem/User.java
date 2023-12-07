/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hostelmanagementsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author G5
 */
public class User {
    
    public int login(String username, String password) {
        String filePath = "C:\\Users\\G5\\Documents\\NetBeansProjects\\HOSTELManagementSystem\\src\\main\\java\\Databases\\students.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] user = line.split(",");
                String storedUsername = user[0];
                String storedPassword = user[5];

                if (username.equals("admin") && password.equals("admin")) {
                        return 0; // Admin login
                    }
                
                if (username.equals(storedUsername) && password.equals(storedPassword)) {
                    return 1; // User login
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1; // Invalid credentials
    }
}
