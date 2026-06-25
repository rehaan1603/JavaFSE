import java.util.Scanner;

public class FinancePredictor {

    static double calculateFutureAmount(double presentAmount, double yearlyIncreaseRate, int totalYears) {
        if (totalYears == 0) {
            return presentAmount;
        }

        return calculateFutureAmount(
                presentAmount * (1 + yearlyIncreaseRate / 100),
                yearlyIncreaseRate,
                totalYears - 1
        );
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Financial Forecast Tool");

        System.out.print("Enter current amount: ");
        double startingAmount = inputScanner.nextDouble();

        System.out.print("Enter annual growth rate (%): ");
        double annualRate = inputScanner.nextDouble();

        System.out.print("Enter number of years: ");
        int yearsCount = inputScanner.nextInt();

        double predictedAmount = calculateFutureAmount(startingAmount, annualRate, yearsCount);

        System.out.printf("\nPredicted value after %d years: %.2f\n", yearsCount, predictedAmount);

        inputScanner.close();
    }
}