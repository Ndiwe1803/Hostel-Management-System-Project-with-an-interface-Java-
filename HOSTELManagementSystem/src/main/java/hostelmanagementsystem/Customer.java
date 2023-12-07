/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hostelmanagementsystem;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author G5
 */
public class Customer extends User{


    private static final String BOOKINGS_FILE_PATH = "C:\\Users\\G5\\Documents\\NetBeansProjects\\HOSTELManagementSystem\\src\\main\\java\\Databases\\bookings.txt";

    public void makeBooking(String roomID, String username, String startDate, String endDate) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKINGS_FILE_PATH, true))) {
            String bookingRecord = roomID + "," + username + "," + startDate + "," + endDate + ",pending";
            writer.write(bookingRecord);
            writer.newLine();
            System.out.println("Booking has been made successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while making the booking: " + e.getMessage());
        }
    }
    
     public boolean validateStudentID(String studentID) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\G5\\Documents\\NetBeansProjects\\HOSTELManagementSystem\\src\\main\\java\\Databases\\students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 1 && parts[0].equals(studentID.trim())) {
                    return true;
                }
            }
        } catch (IOException e) {
            // Handle the exception or show an alert
            e.printStackTrace();
        }
        return false; // Student ID not found or error occurred
    }
}
