import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final byte month_in_year = 12;
        final byte percent = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest: ");
        float interest = scanner.nextFloat();
        float monthlyInterest = interest/percent/month_in_year;

        System.out.print("Years: ");
        int years = scanner.nextInt();
        int numberOfPayments = years*month_in_year;

        //mortgage formula = p*(i*(1+y)^n)/((1+y)^n-1)
        double brackets = Math.pow(1+monthlyInterest,numberOfPayments);
        double mortgage = principal * ((monthlyInterest*brackets)/(brackets-1));

        NumberFormat mortgageUpdate = NumberFormat.getCurrencyInstance();
        String result = mortgageUpdate.format(mortgage);
        System.out.print("Mortgage: " + result);

    }
}