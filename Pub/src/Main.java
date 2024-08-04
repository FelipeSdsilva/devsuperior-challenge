import entities.Bill;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Sexo: ");
        char gender = sc.next().charAt(0);
        System.out.print("Quantidade de cervejas: ");
        int beer = sc.nextInt();
        System.out.print("Quantidade de refrigerantes: ");
        int softDrink = sc.nextInt();
        System.out.print("Quantidade de espetinhos: ");
        int barbecue = sc.nextInt();

        Bill bill = new Bill(gender, beer, barbecue, softDrink);
        System.out.println(bill);

        sc.close();
    }
}