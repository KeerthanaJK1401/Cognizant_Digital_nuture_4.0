package forecasting;
import java.util.Scanner;

public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double forecastRecursive(double amount, double rate, int years) {
        if (years == 0) return amount;  // Base case
        return (1 + rate) * forecastRecursive(amount, rate, years - 1);  // Recursive call
    }

    // Iterative method (optimized)
    public static double forecastIterative(double amount, double rate, int years) {
        double result = amount;
        for (int i = 1; i <= years; i++) {
            result *= (1 + rate);
        }
        return result;
    }

    // Forecast year-by-year growth
    public static void printYearlyForecast(double amount, double rate, int years) {
        System.out.println("\nYear-by-Year Forecast (Iterative):");
        for (int i = 0; i <= years; i++) {
            double futureValue = forecastIterative(amount, rate, i);
            System.out.printf("Year %d: ₹%.2f%n", i, futureValue);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get input from user
        System.out.print("Enter initial investment amount (₹): ");
        double initialAmount = sc.nextDouble();

        System.out.print("Enter annual growth rate (e.g., 0.08 for 8%): ");
        double annualGrowthRate = sc.nextDouble();

        System.out.print("Enter number of years to forecast: ");
        int years = sc.nextInt();

        // Forecast using recursive method
        double futureValueRecursive = forecastRecursive(initialAmount, annualGrowthRate, years);
        System.out.printf("\n[Recursive] Forecasted value after %d years: ₹%.2f\n", years, futureValueRecursive);

        // Forecast using iterative method
        double futureValueIterative = forecastIterative(initialAmount, annualGrowthRate, years);
        System.out.printf("[Iterative] Forecasted value after %d years: ₹%.2f\n", years, futureValueIterative);

        // Print year-by-year forecast
        printYearlyForecast(initialAmount, annualGrowthRate, years);

        sc.close();
    }
}
