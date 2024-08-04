import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<TaxPayer> taxPayers = new ArrayList<>();

        System.out.print("Quantos contribuintes você vai digitar? ");
        int taxpayerQuantity = sc.nextInt();
        System.out.println();

        taxPayers.clear();
        for (int i = 1; i <= taxpayerQuantity; i++) {
            System.out.println("Digite os dados do " + i + "º contribuinte:");
            System.out.print("Renda anual com salário: ");
            Double salaryIncome = sc.nextDouble();
            System.out.print("Renda anual com prestação de serviço: ");
            Double servicesIncome = sc.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            Double capitalIncome = sc.nextDouble();
            System.out.print("Gastos médicos: ");
            Double healthSpending = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            Double educationSpending = sc.nextDouble();
            System.out.println();

            TaxPayer taxPayer = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);
            taxPayers.add(taxPayer);
        }

        AtomicInteger index = new AtomicInteger(1);

        taxPayers.forEach(payer -> {
            int currentIndex = index.getAndIncrement();
            System.out.println("Resumo do " + currentIndex + "º contribuinte:");
            System.out.println(payer);
            System.out.println();
        });

        sc.close();
    }
}