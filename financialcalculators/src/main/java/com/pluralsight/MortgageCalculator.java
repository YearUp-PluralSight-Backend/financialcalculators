package com.pluralsight;

import java.util.Scanner;

/**
 * The MortgageCalculator class calculates monthly mortgage payments and the total interest paid over the loan term.
 *
 * <p>
 * It uses the following mortgage formula to calculate the monthly payment:
 * M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1 ]
 *
 * Where:
 * M: is the monthly payment
 * P: is the loan amount (principal)
 * i: is the monthly interest rate (annual interest rate divided by 12)
 * n: is the total number of monthly payments (years of loan multiplied by 12)
 * </p>
 *
 * <p>The class provides two key calculations:
 * <ul>
 *   <li>Monthly Payment: The amount to be paid each month for the mortgage.</li>
 *   <li>Total Interest: The total interest paid over the loan term.</li>
 * </ul>
 *
 * The user is prompted to input the principal amount, interest rate, and loan term in years.
 */
public class MortgageCalculator {

    // Instance variables
    private double principal;  // The principal loan amount
    private double interestRate;  // Annual interest rate (in percentage)
    private int yearsOfLoan;  // Loan term in years
    private double monthlyPayment;  // Calculated monthly mortgage payment

    /**
     * Default constructor for MortgageCalculator.
     */
    public MortgageCalculator() {
    }

    /**
     * Constructor to initialize a MortgageCalculator with specified principal, interest rate, and loan term.
     *
     * @param principal The loan amount (principal)
     * @param interestRate The annual interest rate (as a percentage)
     * @param yearsOfLoan The loan term in years
     */
    public MortgageCalculator(double principal, double interestRate, int yearsOfLoan) {
        this.principal = principal;
        this.interestRate = interestRate;
        this.yearsOfLoan = yearsOfLoan;
    }

    // Getter and setter methods for principal, interest rate, and years of loan

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

    /**
     * Calculates the monthly mortgage payment using the formula:
     * M = P [ i(1 + i)^n ] / [ (1 + i)^n - 1 ]
     * Where:
     * M is the monthly payment,
     * P is the loan amount (principal),
     * i is the monthly interest rate (annual interest rate divided by 12),
     * n is the number of months (loan term in years * 12).
     */
    public void calculateMonthlyPayment() {
        double monthlyInterestRate = (this.interestRate / 100) / 12;  // Convert annual rate to monthly
        int monthsOfLoan = this.yearsOfLoan * 12;  // Total number of payments
        this.monthlyPayment = this.principal *
                (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, monthsOfLoan)) /
                (Math.pow(1 + monthlyInterestRate, monthsOfLoan) - 1);
    }

    /**
     * Gets the calculated monthly payment.
     *
     * @return The monthly mortgage payment.
     */
    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    /**
     * Calculates the total interest paid over the term of the loan.
     *
     * @return The total interest paid.
     */
    public double getTotalOfInterest() {
        double totalPaid = this.monthlyPayment * (yearsOfLoan * 12);  // Total paid over loan period
        return totalPaid - principal;  // Interest is total paid minus the principal
    }

    /**
     * The main method prompts the user to input the principal, interest rate, and loan term (in years),
     * and then calculates and prints the monthly payment and total interest over the loan term.
     *
     * @param args Command-line arguments (unused).
     */
    public static void main(String[] args) {
        // Create a new MortgageCalculator object
        MortgageCalculator mortgageCalculator = new MortgageCalculator();

        // Try-with-resources for safe handling of Scanner input
        try (Scanner scanner = new Scanner(System.in)) {
            // Get input from the user
            System.out.println("Enter the Principal: ");
            double principal = scanner.nextDouble();

            System.out.println("Enter the interest rate: ");
            double interestRate = scanner.nextDouble();

            System.out.println("Enter the loan Length (in years): ");
            int loanLength = scanner.nextInt();

            // Set the mortgage details
            mortgageCalculator.setPrincipal(principal);
            mortgageCalculator.setInterestRate(interestRate);
            mortgageCalculator.setYearsOfLoan(loanLength);

            // Perform the calculations
            mortgageCalculator.calculateMonthlyPayment();
            double totalOfInterest = mortgageCalculator.getTotalOfInterest();

            // Output the results
            System.out.printf("Monthly payment: %.2f%n", mortgageCalculator.getMonthlyPayment());
            System.out.printf("Total interest paid: %.2f%n", totalOfInterest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
