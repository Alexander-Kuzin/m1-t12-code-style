import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {
        new DepositCalculator().handleUserInput();
    }

    void handleUserInput() {
        int amount;
        int yearCount;
        int depositType;
        double yearRate = 0.06;
        double finalResult= 0.0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        yearCount = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();

        if (depositType == 1) {
            finalResult = calculateSimplePercent(amount, yearRate, yearCount);
        } else if (depositType == 2) {
            finalResult = calculateComplexPercent(amount, yearRate, yearCount);
        }
        System.out.println("Результат вклада: " + amount + " за " + yearCount + " лет превратятся в " + finalResult);
    }

    double calculateComplexPercent(double amount, double yearRate, int yearCount) {
        double result = amount * Math.pow((1 + yearRate / 12), 12 * yearCount);
        return roundResult(result, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int yearCount) {
        return roundResult(amount + amount * yearRate * yearCount, 2);
    }

    double roundResult(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
