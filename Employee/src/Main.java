import entities.Address;
import entities.Department;
import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        System.out.print("Nome do departamento: ");
        String name = sc.nextLine();
        System.out.print("Dia do pagamento: ");
        Integer payDay = sc.nextInt();
        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Telefone: ");
        String phone = sc.nextLine();
        System.out.print("Quantos funcionários tem o departamento ? ");
        Integer countEmployee = sc.nextInt();
        sc.nextLine();
        Department dep = new Department(name, payDay, new Address(email, phone));

        for (int i = 1; i <= countEmployee; i++) {
            System.out.println("Dados do funcionário " + i + ":");
            System.out.print("Nome: ");
            String nameEmp = sc.nextLine();
            System.out.print("Salário: ");
            Double salary = sc.nextDouble();
            sc.nextLine();
            dep.getEmployees().add(new Employee(nameEmp, salary));
        }

        showReport(dep);

        sc.close();
    }

    private static void showReport(Department dept) {
        StringBuilder employeeDetails = new StringBuilder();

        for (Employee employee : dept.getEmployees()) {
            employeeDetails.append(String.format("%s%n", employee.getName()));
        }

        System.out.printf("""
                
                FOLHA DE PAGAMENTO:
                Departamento %s = %.2f
                Pagamento realizado no dia %d
                Funcionários:
                %s
                Para dúvidas favor entrar em contato: %s
                """, dept.getName(), dept.payroll(), dept.getPayDay(), employeeDetails, dept.getAddress().getEmail());

    }
}