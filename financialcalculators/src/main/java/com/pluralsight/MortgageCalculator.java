package com.pluralsight;

import java.util.Scanner;

/**
 *
 * fomula
 * The formula to calculate a mortgage payment is M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1, where:
 * M: is the monthly payment
 * P: is the loan amount, or principal
 * i: is the interest rate, divided by 12
 * n: is the number of monthly payments
 *
 * The MortgageCalculator class provides user to get the monthlyPayment, totalOfInterest
 * It will ask user to input the principal, interestRate, yearsOfLoan
 */

public class MortgageCalculator {


    private double principal;
    private double interestRate;
    private int yearsOfLoan;
    private double monthlyPayment;

    public MortgageCalculator() {
    }

    public MortgageCalculator(double principal, double interestRate, int yearsOfLoan) {
        this.principal = principal;
        this.interestRate = interestRate;
        this.yearsOfLoan = yearsOfLoan;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getYearsOfLoan() {
        return yearsOfLoan;
    }

    public void setYearsOfLoan(int yearsOfLoan) {
        this.yearsOfLoan = yearsOfLoan;
    }

    @Override
    public String toString() {
        return "MortgageCalculator{" +
                "principal=" + principal +
                ", interestRate=" + interestRate +
                ", yearsOfLoan=" + yearsOfLoan +
                '}';
    }

    /**
     *  calculate the monthlyPayment
     * M = P [ i(1 + i)^n ] / [ (1 + i)^n - 1
     * M: is the monthly payment
     * P: is the loan amount, or principal
     * i: is the interest rate, divided by 12
     * n: is the number of monthly payments
     * @return double
     */
    public void calculateMonthlyPayment() {
//        M = P [ i(1 + i)^n ] / [ (1 + i)^n - 1]
        double monthlyInterestRate = this.interestRate / 12;
        int monthsofLoan = this.yearsOfLoan * 12;
        this.monthlyPayment = this.principal * Math.pow((monthlyInterestRate * ( 1 + monthlyInterestRate)), monthsofLoan) /
                (Math.pow(1 + monthlyInterestRate, monthsofLoan) - 1);
    }

    /**
     * to get the total of amount to pay by monlyPyament * months of the loan
     * @return double
     */
    public double getTotalOfInterest() {
    double total = this.monthlyPayment * (yearsOfLoan * 12);
    return total - principal;

    }

    public double getUserInput() {
        Scanner scanner = new Scanner(System.in);
        double value = scanner.nextDouble();
        scanner.close();;
        return value;
    }


    public static void main(String[] args) {

        MortgageCalculator MortgageCalculator = new MortgageCalculator();

        System.out.println("Enter the Principal: ");
        double principal = MortgageCalculator.getUserInput();

        System.out.println("Enter the Principal: ");
        double interestRate = MortgageCalculator.getUserInput();

        System.out.println("Enter the Principal: ");
        double loanLenth = MortgageCalculator.getUserInput();

        MortgageCalculator.setPrincipal(principal);
        MortgageCalculator.setInterestRate(interestRate);
        MortgageCalculator.setYearsOfLoan(Integer.parseInt(loanLenth + ""));


    }



}
