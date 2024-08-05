import entities.Lesson;
import entities.Task;
import entities.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Lesson> lessons = new ArrayList<>();


        System.out.print("Quantas aulas tem o curso? ");
        int quantityOfLessons = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= quantityOfLessons; i++) {

            System.out.println("\nDados da " + i + "a aula:");
            System.out.print("Conteúdo ou tarefa (c/t)? ");
            char videoOrTask = sc.next().charAt(0);
            sc.nextLine();

            System.out.print("Título: ");
            String title = sc.nextLine();

            if (videoOrTask == 'c') {
                System.out.print("URL do vídeo: ");
                String url = sc.nextLine();
                System.out.print("Duração em segundos: ");
                Integer seconds = sc.nextInt();

                lessons.add(new Video(title, url, seconds));
            } else {
                System.out.print("Descrição: ");
                String description = sc.nextLine();
                System.out.print("Quantidade de questões: ");
                Integer questionCount = sc.nextInt();
                sc.nextLine();

                lessons.add(new Task(title, description, questionCount));
            }

        }

        System.out.println("\nDURAÇÃO TOTAL DO CURSO = " + lessons.stream().mapToInt(Lesson::duration).sum() + " segundos");
        sc.close();
    }
}