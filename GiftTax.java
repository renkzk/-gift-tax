import java.util.Scanner;

public class GiftTax {

    static class TaxBracket {
        int min;
        int base;
        double rate;

        public TaxBracket(int min, int base, double rate) {
            this.min = min;
            this.base = base;
            this.rate = rate;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Value of the gift?");
        int value = Integer.parseInt(scan.nextLine());
        double tax = calculateTax(value);

        if (tax == 0) {
            System.out.println("No tax!");
        } else {
            System.out.println("Tax: " + tax);
        }
    }

    public static double calculateTax(int value) {
        TaxBracket[] brackets = {
                new TaxBracket(0, 0, 0.0),
                new TaxBracket(5000, 100, 0.08),
                new TaxBracket(25000, 1700, 0.10),
                new TaxBracket(55000, 4700, 0.12),
                new TaxBracket(200000, 22100, 0.15),
                new TaxBracket(1000000, 142100, 0.17)
        };

        double tax = 0;

        for (int i = 1; i < brackets.length; i++) {
            if (value >= brackets[i].min) {
                tax = brackets[i].base + (value - brackets[i].min) * brackets[i].rate;
            }
        }
        return tax;
    }
}