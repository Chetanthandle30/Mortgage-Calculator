import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final byte month_in_year = 12;
        final byte percent = 100;

        int principal=0;
        int years=0;
        float interest = 0;
        int numberOfPayments= 0;
        float monthlyInterest= 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000) {
                break;
            }
            System.out.println("Enter a valid number between 1000 and 1000000");
        }

        while (true) {
            System.out.print("Annual Interest: ");
            interest = scanner.nextFloat();
            if (interest > 0 ) {
                monthlyInterest = interest / percent / month_in_year;
                break;
            }
            System.out.println("Enter a valid interest number");

        }

        while (true){
            System.out.print("Years: ");
            years = scanner.nextInt();
            if (years >= 1 && years <= 30) {
                numberOfPayments = years * month_in_year;
                break;
            }
            System.out.println("Enter a valid year between 0 and 30");
        }

        //mortgage formula = p*(i*(1+y)^n)/((1+y)^n-1)
        double brackets = Math.pow(1+monthlyInterest,numberOfPayments);
        double mortgage = principal * ((monthlyInterest*brackets)/(brackets-1));

        NumberFormat mortgageUpdate = NumberFormat.getCurrencyInstance();
        String result = mortgageUpdate.format(mortgage);
        System.out.print("Mortgage: " + result);
    }
}
