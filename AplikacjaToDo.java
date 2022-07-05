package com.testarmy.aplikacjaToDo;

import java.util.*;

public class AplikacjaToDo {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Funkcje funkcje = new Funkcje();

        funkcje.loadAll();
        int option;
        do {

            Funkcje.DisplayMenu();


            option = Funkcje.getInt(scanner, 1, 6);

            {
                if (option == 1) {
                    System.out.println("Podaj prawidłowe dane");
                    funkcje.userAddTask();

                } else if (option == 2) {
                    funkcje.deleteTask(funkcje.getTask());
                } else if (option == 3) {
                    System.out.println("Wybierz sposób sortowania");
                    System.out.println("1- alfabetycznie po tytule");
                    System.out.println("2- najbliższe terminem ");
                    System.out.println("3- według osoby odpowiedzialnej alfabetycznie");
                    System.out.println("4- rosnąco priorytetem");
                    System.out.println("5- Wyświtl zadania ukończone ");
                    System.out.println("6- Wysiwtl zadania do wykonania");
                    int option2 = scanner.nextInt();
                    if (option2 == 1) {

                        funkcje.printList(Comparator.comparing(Task::getTitle));
                    } else if (option2 == 2) {

                        Date date = new Date();
                        System.out.println("Coming soon");
                    } else if (option2 == 3) {

                        funkcje.printList(Comparator.comparing(Task::getPersonResponsible));
                    } else if (option2 == 4) {
                        funkcje.printList(Comparator.comparingInt(Task::getPriorities));
                    } else if (option2 == 5) {
                        System.out.println("Coming soon");
                    }
                    // taskList.sort(a->a.isTaskFinished(taskList);

                    else if (option2 == 6) {
                        System.out.println("Coming soon");
                    }
                } else if (option == 4) {
                    funkcje.edytor(funkcje.getTask());


                } else if (option == 5) {
                    System.out.println("Do zobaczenia :)");
                } else {
                    System.out.println("Nie ma takiej opcji");
                }

            }


        } while (option != 5);
    }
}



