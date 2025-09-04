/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Series app = new Series();
        Scanner input = new Scanner(System.in);
                

        while (true) {
            System.out.println("\n===== TV SERIES MENU =====");
            System.out.println("1. Capture New Series");
            System.out.println("2. Search Series");
            System.out.println("3. Update Series");
            System.out.println("4. Delete Series");
            System.out.println("5. View Series Report");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String choice = input.nextLine();

            switch (choice) {
                case "1" -> {
                    SeriesModel model = null;
                    app.captureSeries(model);
                }

                case "2" -> app.searchSeries("S01");
                case "3" -> app.updateSeries("S01", "Updated Show", 18, 12);   
                case "4" -> app.deleteSeries();   
                case "5" -> app.seriesReport();
                case "6" -> app.exitSeriesApplication();
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
