package com.koheitech;

import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    final static byte MONTH_IN_YEAR = 12;
    final static byte PERCENT = 100;
    public static void main(String[] args) {

        double principal = Console.readNumber("Principle($1K - $1M): ", 1_000, 1_000_000);
        double annualInterest = Console.readNumber("Annual Interest Rate(%): ", 0.01, 100);
        double year = Console.readNumber("Period (Year): ", 1, 30);

        printMortgage(principal, annualInterest, year);
        printPaymentSchedule(principal, annualInterest, year);
    }

    public static void printPaymentSchedule(double principal, double annualInterest, double year) {
        System.out.println("---------- PAYMENT SCHEDULE ----------");
        for (short month = 1; month <= year * MONTH_IN_YEAR; ++month) {
            double balance = calculateBalance(principal, annualInterest, year, month);
            String balanceFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(balance);
            System.out.println(balanceFormatted);
        }
    }

    public static void printMortgage(double principal, double annualInterest, double year) {
        double mortgage = calculateMortgage(principal, annualInterest, year);
        System.out.println("---------- MORTGAGE ----------");
        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    public static double calculateBalance(double principal, double annualInterest, double year, short numberOfPaymentsMade) {
        double monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;
        double numberOfPayments = year * MONTH_IN_YEAR;

        return principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

    public static double calculateMortgage(double principal, double annualInterest, double year) {
        double monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;
        double numberOfPayments = year * MONTH_IN_YEAR;

        return principal
                * ( monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
}
