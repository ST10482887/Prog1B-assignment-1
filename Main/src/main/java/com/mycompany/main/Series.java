 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    private ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    // Capture a new series
    public void captureSeries(SeriesModel model) {
        System.out.print("Enter Series ID: ");
        String id = input.nextLine().trim();

        System.out.print("Enter Series Name: ");
        String name = input.nextLine().trim();

        String age;
        while (true) {
            System.out.print("Enter Age Restriction (2–18): ");
            age = input.nextLine().trim();
            try {
                int ageNum = Integer.parseInt(age);
                if (ageNum >= 2 && ageNum <= 18) {
                    break;
                } else {
                    System.out.println("Invalid age. Must be between 2 and 18.");
                }
            } catch (NumberFormatException enter) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        System.out.print("Enter Number of Episodes: ");
        String episodes = input.nextLine().trim();

        SeriesModel s = new SeriesModel(id, name, age, episodes);
        seriesList.add(s);

        System.out.println("Series successfully saved!");
    }

    // Search for a series by ID
    public void searchSeries(String s01) {
        System.out.print("Enter Series ID to search: ");
        String id = input.nextLine().trim();

        boolean found = false;
        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equalsIgnoreCase(id)) {
                System.out.println("Series Found:");
                System.out.println(s);  
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No series data could be found.");
        }
    }

    // Update a series
    public void updateSeries(String s01, String updated_Show, int par, int par1) {
        System.out.print("Enter Series ID to update: ");
        String id = input.nextLine().trim();

        boolean found = false;
        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equalsIgnoreCase(id)) {
                System.out.print("Enter new Series Name: ");
                s.setSeriesName(input.nextLine().trim());

                String age;
                while (true) {
                    System.out.print("Enter new Age Restriction (2–18): ");
                    age = input.nextLine().trim();
                    try {
                        int ageNum = Integer.parseInt(age);
                        if (ageNum >= 2 && ageNum <= 18) {
                            s.setSeriesAge(age);
                            break;
                        } else {
                            System.out.println("Invalid age. Must be between 2 and 18.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                }

                System.out.print("Enter new Number of Episodes: ");
                s.setSeriesNumberOfEpisodes(input.nextLine().trim());

                System.out.println("Series updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Series not found.");
        }
    }

    // Delete a series
    public void deleteSeries() {
        System.out.print("Enter Series ID to delete: ");
        String id = input.nextLine().trim();

        SeriesModel found = null;
        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equalsIgnoreCase(id)) {
                found = s;
                break;
            }
        }

        if (found != null) {
            System.out.print("Are you sure you want to delete this series? (Yes/No): ");
            String confirm = input.nextLine().trim();
            if (confirm.equalsIgnoreCase("Yes")) {
                seriesList.remove(found);
                System.out.println("Series deleted successfully!");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Series not found.");
        }
    }

    // Report
    public void seriesReport() {
        System.out.println("\n=== SERIES REPORT ===");
        if (seriesList.isEmpty()) {
            System.out.println("No series captured yet.");
        } else {
            for (SeriesModel s : seriesList) {
                System.out.println(s);
            }
        }
    }

    // Exit
    public void exitSeriesApplication() {
        System.out.println("Exiting application... Goodbye!");
        System.exit(0);
    }
}
