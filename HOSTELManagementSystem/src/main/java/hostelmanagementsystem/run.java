/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hostelmanagementsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author G5
 */
public class run {
    public static void main(String args[]){
        System.out.println(convertStringToDate("15-07-2023"));
        
    }
    
    public static LocalDate convertStringToDate(String dateString) {
        LocalDate date = null;

        try {
            // Define the pattern of the input date string
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // Parse the date string to LocalDate
            date = LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            // Handle invalid date format
            System.out.println("Invalid date format: " + dateString);
        }

        return date;
    }
}
