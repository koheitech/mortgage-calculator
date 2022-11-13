package com.koheitech;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {
    private MortgageCalculator calculator;
    private final NumberFormat currency;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance(Locale.US);
    }


    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        System.out.println("---------- MORTGAGE ----------");
        System.out.println("Monthly Payments: " + currency.format(mortgage));
    }

    public void printPaymentSchedule() {
        System.out.println("---------- PAYMENT SCHEDULE ----------");
        for (double balance : calculator.getRemainingBalances())
            System.out.println(currency.format(balance));
    }
}
