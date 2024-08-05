import entities.Sale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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

            Map<String, Double> totalBySeller = sales.stream()
                    .collect(Collectors.groupingBy(
                            Sale::getSeller,
                            Collectors.summingDouble(Sale::getTotal)
                    ));

            System.out.println("Total de vendas por vendedor:");
            totalBySeller.forEach((seller, total) ->
                    System.out.printf("%s - R$ %.2f%n", seller, total)
            );

        } catch (IOException e) {
            System.err.println("Erro: " + filePath + " (" + e.getMessage() + ")");
        }
    }
}
