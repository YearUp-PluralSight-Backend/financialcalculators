package com.pluralsight;

import java.util.Scanner;

/**
 * The CDCalculator class is used to calculate the balance and interest on a Certificate of Deposit (CD)
 * based on compound interest. It takes input from the user, including the principal deposit, interest rate,
 * the number of years of deposit, and the frequency of compounding.
 *
 *  The formula used to calculate compound interest is:
 *  A = P(1 + r/n)^(nt)
 *  Where:
 *  The principal amount (initial deposit)
 *  The annual interest rate (as a decimal)
 *  The number of times interest is compounded per year
 *  The time the money is invested or borrowed for, in years
 *  The final balance after interest has been applied
 *  Calculate the total balance after the specified time
 *  Calculate the total interest earned
 */
public class CDCalculator {

    // Instance variables
    private double deposit;  // The principal deposit amount
    private double interestRate;  // Annual interest rate in percentage
    private double yearOfDeposit;  // Number of years the deposit will be held
    private int compoundedTime;  // Frequency of compounding per year

    /**
     * Default constructor for the CDCalculator class.
     */
    public CDCalculator() {
    }

    /**
     * Parameterized constructor for the CDCalculator class.
     *
     * @param deposit The principal deposit amount
     * @param interestRate The annual interest rate
     * @param yearOfDeposit The number of years the deposit will be held
     * @param compoundedTime The frequency of compounding per year
     */
    public CDCalculator(double deposit, double interestRate, double yearOfDeposit, int compoundedTime) {
        this.deposit = deposit;
        this.interestRate = interestRate;
        this.yearOfDeposit = yearOfDeposit;
        this.compoundedTime = compoundedTime;
    }

    // Getters and setters for each instance variable
    public int getCompoundedTime() {
        return compoundedTime;
    }

    public void setCompoundedTime(int compoundedTime) {
        this.compoundedTime = compoundedTime;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getYearOfDeposit() {
        return yearOfDeposit;
    }

    public void setYearOfDeposit(double yearOfDeposit) {
        this.yearOfDeposit = yearOfDeposit;
    }

    @Override
    public String toString() {
        return "CDCalculator{" +
                "deposit=" + deposit +
                ", interestRate=" + interestRate +
                ", yearOfDeposit=" + yearOfDeposit +
                '}';
    }

    /**
     * This method calculates the total balance after the deposit has been compounded for a given number of years,
     * using the compound interest formula:
     *
     * A = P(1 + r/n)^(nt)
     *
     * <p>Where:</p>
     * <ul>
     *   <li>P is the principal (the starting amount)</li>
     *   <li>r is the annual interest rate, expressed as a decimal</li>
     *   <li>n is the number of times the interest is compounded per year</li>
     *   <li>t is the total number of years</li>
     *   <li>A is the total amount at the end of the time period</li>
     * </ul>
     */
    public void calculateCD() {
        this.interestRate /= 100;  // Convert percentage to decimal
        double balance = this.deposit * Math.pow((1 + (this.interestRate / 365.0)), (365 * yearOfDeposit));  // Compound interest calculation
        System.out.printf("Balance: %.4f\n", balance);
        System.out.printf("Interest: %.4f\n", (balance - deposit));
    }

    /**
     * Main method to take user input for deposit details, perform the compound interest calculation,
     * and display the resulting balance and interest.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            // Input: Principal deposit
            System.out.println("Enter the Principal: ");
            double principal = scanner.nextDouble();

            // Input: Annual interest rate
            System.out.println("Enter the interest rate: ");
            double interestRate = scanner.nextDouble();

            // Input: Length of the deposit in years
            System.out.println("Enter the loan Length: ");
            int yearOfDeposit = scanner.nextInt();

            // Input: Compounding frequency
            System.out.println("Enter the compounded time: ");
            int compoundedTime = scanner.nextInt();

            // Create a CDCalculator object with the user's input
            CDCalculator cdCalculator = new CDCalculator(principal, interestRate, yearOfDeposit, compoundedTime);

            // Perform the CD calculation and display the results
            cdCalculator.calculateCD();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
