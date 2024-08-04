import entities.Champion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite os dados do primeiro campeão:");
        System.out.print("Nome: ");
        String name1 = sc.nextLine();
        System.out.print("Vida inicial: ");
        int life1 = sc.nextInt();
        System.out.print("Ataque: ");
        int attack1 = sc.nextInt();
        System.out.print("Armadura: ");
        int armor1 = sc.nextInt();
        sc.nextLine();

        Champion champion1 = new Champion(name1, life1, attack1, armor1);

        System.out.println("\nDigite os dados do segundo campeão:");
        System.out.print("Nome: ");
        String name2 = sc.nextLine();
        System.out.print("Vida inicial: ");
        int life2 = sc.nextInt();
        System.out.print("Ataque: ");
        int attack2 = sc.nextInt();
        System.out.print("Armadura: ");
        int armor2 = sc.nextInt();
        sc.nextLine();

        Champion champion2 = new Champion(name2, life2, attack2, armor2);


        System.out.print("\nQuantos turnos você deseja executar? ");
        int turns = sc.nextInt();

        for (int i = 1; i <= turns; i++) {
            champion1.takeDamage(champion2);
            champion2.takeDamage(champion1);

            System.out.printf("\nResultado do turno %d: ", i);
            System.out.print(champion1.status());
            System.out.print(champion2.status());
            System.out.println();
            if (champion1.getLife() <= 0 && champion2.getLife() <= 0) {
                break;
            } else if (champion1.getLife() <= 0) {
                break;
            } else if (champion2.getLife() <= 0) {
                break;
            }
        }

        System.out.println("\nFIM DO COMBATE");

        sc.close();
    }
}