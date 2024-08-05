import entities.Sale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre o caminho do arquivo: ");
        String filePath = sc.nextLine();

        List<Sale> sales = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                Integer month = Integer.valueOf(values[0].trim());
                Integer year = Integer.valueOf(values[1].trim());
                String seller = values[2].trim();
                Integer items = Integer.valueOf(values[3].trim());
                Double total = Double.valueOf(values[4].trim());

                sales.add(new Sale(month, year, seller, items, total));
            }

            List<Sale> topSales2016 = sales.stream()
                    .filter(sale -> sale.getYear().equals(2016))
                    .sorted(Comparator.comparing(Sale::averagePrice).reversed())
                    .limit(5)
                    .toList();

            System.out.println("Cinco primeiras vendas de 2016 de maior preço médio:");
            topSales2016.forEach(System.out::print);

            Double totalLogan = sales.stream()
                    .filter(sale -> sale.getSeller().equals("Logan") &&
                            (sale.getMonth().equals(1) || sale.getMonth().equals(7)))
                    .mapToDouble(Sale::getTotal)
                    .sum();

            System.out.printf("Valor total vendido pelo vendedor Logan nos meses 1 e 7 = %.2f", totalLogan);
        } catch (IOException e) {
            System.out.println("Erro: " + filePath + " (" + e.getMessage() + ")");
        }
    }
}
