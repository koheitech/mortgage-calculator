package com.koheitech;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        int principle;
        while(true) {
            System.out.print("Principle($1K - $1M): ");
            principle = scanner.nextInt();

            if (1_000 <= principle && principle <= 1_000_000) break;
            System.out.println("Enter a number between 1,000 and 1,000,000");
        }

        float annualInterest;
        while(true) {
            System.out.print("Annual Interest Rate(%): ");
            annualInterest = scanner.nextFloat();
            if (0 < annualInterest && annualInterest <= 100) break;
            System.out.println("Enter a value greater than 0 or value less or equal to 100");
        }
        float monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;

        int year;
        while (true){
            System.out.print("Period (Year): ");
            year = scanner.nextInt();
            if (1 < year && year <= 30) break;
            System.out.println("Enter a number between 1 and 30");
        }
        int numberOfPayments = year * MONTH_IN_YEAR;

        double mortgage =
                principle *
                        ( monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) /
                        (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);


        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
