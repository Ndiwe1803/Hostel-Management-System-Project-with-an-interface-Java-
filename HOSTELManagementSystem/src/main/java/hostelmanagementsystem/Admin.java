/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hostelmanagementsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author G5
 */
    public class Admin extends User{
        public void addHostelRoom(String roomID, String capacity, String price, String balcony) {
            String filePath = "C:\\Users\\G5\\Documents\\NetBeansProjects\\HOSTELManagementSystem\\src\\main\\java\\Databases\\hostels.txt";

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
                String roomInfo = roomID + "," + capacity + "," + price + "," + balcony;
                bw.write(roomInfo);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
    public void updateHostelRoom(String roomID, String capacity, String price, String balcony) {
        String filePath = "C:\\Users\\G5\\Documents\\NetBeansProjects\\HOSTELManagementSystem\\src\\main\\java\\Databases\\hostels.txt";
        String tempFilePath = "C:\\Users\\G5\\Documents\\NetBeansProjects\\HOSTELManagementSystem\\src\\main\\java\\Databases\\hostels_temp.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] roomInfo = line.split(",");
                String storedRoomID = roomInfo[0];

                if (roomID.equals(storedRoomID)) {
                    // Update the record with the new data
                    line = roomID + "," + capacity + "," + price + "," + balcony;
                }
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Copy the contents from temp file to the original file
        try {
            Files.copy(Paths.get(tempFilePath), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Delete the temporary file
        File tempFile = new File(tempFilePath);
        tempFile.delete();

     }
    
    public void deleteHostelRoom(String roomID) {
        String filePath = "C:\\Users\\G5\\Documents\\NetBeansProjects\\HOSTELManagementSystem\\src\\main\\java\\Databases\\hostels.txt";
        String tempFilePath = "C:\\Users\\G5\\Documents\\NetBeansProjects\\HOSTELManagementSystem\\src\\main\\java\\Databases\\hostels_temp.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] roomInfo = line.split(",");
                String storedRoomID = roomInfo[0];

                if (roomID.equals(storedRoomID)) {
                    // Skip deleting the record with the matching room ID
                    continue;
                }
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Copy the contents from temp file to the original file
        try {
            Files.copy(Paths.get(tempFilePath), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Delete the temporary file
        File tempFile = new File(tempFilePath);
        tempFile.delete();
    }
}   
