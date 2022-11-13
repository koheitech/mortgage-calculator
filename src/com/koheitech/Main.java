package com.koheitech;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double principle = readNumber("Principle($1K - $1M): ", 1_000, 1_000_000);
        double annualInterest = readNumber("Annual Interest Rate(%): ", 0.01, 100);
        double year = readNumber("Period (Year): ", 1, 30);


        double mortgage = calculateMortgage(principle, annualInterest, year);

        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);
        System.out.println("Mortgage per month: " + mortgageFormatted);
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        double input;
        while (true) {
            input = scanner.nextDouble();
            if (min <= input && input <= max) break;
            System.out.println("Enter a number between " + min + " and " + max);
        }
        return input;
    }

    public static double calculateMortgage(double principle, double annualInterest, double year) {
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        double monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;
        double numberOfPayments = year * MONTH_IN_YEAR;

        return principle *
                ( monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) /
                (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
}
