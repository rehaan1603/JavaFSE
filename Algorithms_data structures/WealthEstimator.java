import java.util.Scanner;

public class WealthEstimator {

    static double estimateFutureWorth(double baseValue, double rateOfGrowth, int durationYears) {
        if (durationYears == 0) {
            return baseValue;
        }

        return estimateFutureWorth(
                baseValue * (1 + rateOfGrowth / 100),
                rateOfGrowth,
                durationYears - 1
        );
    }

    public static void main(String[] args) {
        Scanner readerObj = new Scanner(System.in);

        System.out.println("Financial Forecast Tool");

        System.out.print("Enter current amount: ");
        double initialValue = readerObj.nextDouble();

        System.out.print("Enter annual growth rate (%): ");
        double growthPercent = readerObj.nextDouble();

        System.out.print("Enter number of years: ");
        int totalDuration = readerObj.nextInt();

        double finalPrediction = estimateFutureWorth(initialValue, growthPercent, totalDuration);

        System.out.printf("\nPredicted value after %d years: %.2f\n", totalDuration, finalPrediction);

        readerObj.close();
    }
}