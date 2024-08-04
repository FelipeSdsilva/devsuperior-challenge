import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

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

        Double grossSalary = grossTax(salaryTax(salaryIncome), servicesTax(servicesIncome), capitalTax(capitalIncome));
        Double taxRebate = taxRebate(healthSpending, educationSpending, salaryIncome, servicesIncome, capitalIncome);


        System.out.printf("""
                        
                        RELATÓRIO DE IMPOSTO DE RENDA
                        
                        CONSOLIDADO DE RENDA:
                        Imposto sobre salário: %.2f
                        Imposto sobre serviços: %.2f
                        Imposto sobre ganho de capital: %.2f
                        
                        DEDUÇÕES:
                        Máximo dedutível: %.2f
                        Máximo dedutíveis: %.2f
                        
                        RESUMO:
                        Imposto bruto total: %.2f
                        Abatimento: %.2f
                        Imposto devido: %.2f
                        """, salaryTax(salaryIncome),
                servicesTax(servicesIncome),
                capitalTax(capitalIncome),
                grossSalary * 0.30,
                healthSpending + educationSpending,
                grossSalary, taxRebate, netTax(grossSalary, taxRebate));

        sc.close();
    }

    public static Double salaryTax(Double salaryIncome) {
        double salaryPerMonth = salaryIncome / 12;
        if (salaryPerMonth <= 3000) {
            return 0.0;
        } else if (salaryPerMonth > 3000 && salaryPerMonth <= 5000) {
            return salaryIncome * 0.10;
        } else {
            return salaryIncome * 0.20;
        }
    }

    public static Double servicesTax(Double servicesIncome) {
        return servicesIncome * 0.15;
    }

    public static Double capitalTax(Double capitalIncome) {
        return capitalIncome * 0.20;
    }

    public static Double grossTax(Double salaryTax, Double servicesTax, Double capitalTax) {
        return salaryTax + servicesTax + capitalTax;
    }

    public static Double taxRebate(Double healthSpending,
                                   Double educationSpending,
                                   Double salaryIncome,
                                   Double servicesIncome, Double capitalIncome) {
        Double totalSpending = healthSpending + educationSpending;
        Double rebate = grossTax(salaryTax(salaryIncome), servicesTax(servicesIncome), capitalTax(capitalIncome)) * 0.30;
        if (totalSpending < rebate) {
            return totalSpending;
        } else {
            return rebate;
        }
    }

    public static Double netTax(Double grossTax, Double taxRebate) {
        return grossTax - taxRebate;
    }

}