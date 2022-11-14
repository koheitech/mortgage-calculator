package com.koheitech;

import java.util.Scanner;

public class Console {
    /**
     * Methods are set as static since we are going to deal with one console,
     * and we do not need to instantiate this class
     */
    private static Scanner scanner = new Scanner(System.in);


    public static double readNumber(String prompt) {
        return scanner.nextDouble();
    }

    public static double readNumber(String prompt, double min, double max) {
        double input;
        while (true) {
            try {
                System.out.print(prompt);
                while (true) {
                    input = scanner.nextDouble();
                    if (min <= input && input <= max) break;
                    System.out.println("Enter a number between " + min + " and " + max);
                }
                break;
            } catch (Exception e) {
                System.out.println("Please check the input data type.");
                scanner.nextLine();
            }
        }
        return input;
    }
}
