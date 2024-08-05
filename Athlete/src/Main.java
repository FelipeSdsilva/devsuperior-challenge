import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Qual a quantidade de atletas? ");
        int numberOfAthletes = scanner.nextInt();
        scanner.nextLine();

        double totalWeight = 0;
        double maxHeight = 0;
        String tallestAthlete = "";
        int maleCount = 0;
        int femaleCount = 0;
        double totalHeightFemales = 0;

        for (int i = 1; i <= numberOfAthletes; i++) {

            System.out.println("Digite os dados do atleta numero " + i + ":");

            System.out.print("Nome: ");
            String name = scanner.nextLine();

            String gender;
            System.out.print("Sexo: ");
            gender = scanner.nextLine().toUpperCase();
            do {
                if (!gender.equals("F") && !gender.equals("M")) {
                    System.out.print("Valor invalido! Favor digitar F ou M: ");
                    gender = scanner.nextLine().toUpperCase();
                }
            } while (!gender.equals("F") && !gender.equals("M"));

            double height;
            System.out.print("Altura: ");
            height = scanner.nextDouble();
            do {
                if (height <= 0) {
                    System.out.print("Valor invalido! Favor digitar um valor positivo:");
                    height = scanner.nextDouble();
                }
            } while (height <= 0);

            double weight;
            System.out.print("Peso: ");
            weight = scanner.nextDouble();

            do {
                if (weight <= 0) {
                    System.out.print("Valor invalido! Favor digitar um valor positivo: ");
                    weight = scanner.nextDouble();
                }
            } while (weight <= 0);
            scanner.nextLine();


            totalWeight += weight;
            if (height > maxHeight) {
                maxHeight = height;
                tallestAthlete = name;
            }
            if (gender.equals("M")) {
                maleCount++;
            } else {
                femaleCount++;
                totalHeightFemales += height;
            }
        }


        double averageWeight = totalWeight / numberOfAthletes;
        double malePercentage = (maleCount / (double) numberOfAthletes) * 100;
        double averageHeightFemales = (femaleCount > 0) ? totalHeightFemales / femaleCount : 0;

        System.out.printf("""
                                                
                        RELATÓRIO:
                        Peso médio dos atletas: %.2f
                        Atleta mais alto: %s
                        Porcentagem de homens: %.1f %%
                        %s
                        """, averageWeight, tallestAthlete, malePercentage,
                femaleCount > 0 ? String.format("Altura média das mulheres: %.2f", averageHeightFemales) : "Não há mulheres cadastradas");

        scanner.close();
    }
}