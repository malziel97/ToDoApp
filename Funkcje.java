package com.testarmy.aplikacjaToDo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Funkcje {
    private List<Task> taskList;

    public Funkcje() {
        taskList = new ArrayList<>();
    }


    public static void DisplayMenu() {
        System.out.println("Wybierz co chcesz zrobić, klikając na kwiawiaturze odpowiednią cyfrę");
        System.out.println("1- Stworzyć nowe zadanie");
        System.out.println("2- Usunąć zadanie");
        System.out.println("3- Wyświetlić wszystkie zadania");
        System.out.println("4- Edytować zadanie ");
        System.out.println("5- Koniec na dzić ");

    }

    public void loadAll(){
        File fileFolder=new File("Dane");
        File[] files= fileFolder.listFiles();
        for (File file:files)
        {
            fileReader(file);
        }
    }
    public void fileReader(File file) {
        List listofFile = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(file.toPath())) {
            listofFile = bufferedReader.lines().collect(Collectors.toList());


            //System.out.println(listofFile);
        } catch (IOException e) {
            System.out.println(e);
        } catch (RuntimeException e) {
            System.out.println(e);
        }



        addTask(listofFile.get(0).toString(),listofFile.get(1).toString(),listofFile.get(4).toString(),
                listofFile.get(3).toString(),Integer.parseInt(listofFile.get(2).toString())
                ,Boolean.parseBoolean(listofFile.get(5).toString()));
    }

    public static void saveTaskToFile(Task task) {


        while (true) {

            try
                    (FileWriter fileWriter = new FileWriter(task.getFileLocation())) {//
                fileWriter.write(task.getTitle() + "\n");
                fileWriter.write(task.getDescription() + "\n");
                fileWriter.write(task.getPriorities() + "\n");
                fileWriter.write(task.getPersonResponsible() + "\n");
                fileWriter.write(task.getData() + "\n");
                fileWriter.write(task.isTaskFinished() + "");

                System.out.println("Zadanie zapisane,wracamy do menu");
                break;
            } catch (FileNotFoundException e) {
                System.out.println("Nie ma takiego pliku");
                break;
            } catch (IOException e) {
            }

        }

    }

    public Task getTask() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Podaj tytuł zadania do edycji");
            String input = scanner.nextLine();
            for (Task task : taskList) {
                if (task.getTitle().equals(input)) {
                    return task;
                }
            }
            System.out.println("Zły tytuł,podaj ponownie");
        }
    }

    public void deleteTask(Task task) {

        try {
            File file = new File("Dane/" + task + ".txt");
            file.delete();
            taskList.remove(task);
            System.out.println("Zadanie pomyslnie usunięte");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index poza zakresem");

        } catch (UnsupportedOperationException e) {
            System.out.println("Operacja niemolżliwa");
        }
    }

    public void edytor(Task task) {
        System.out.println("Wybierz zmienna do zmiany");
        System.out.println("1- tytuł, 2-opis,3-pryiorytet,4-Osoba odpowiedzialna,5-termin,6-czyUkonczone");
        Scanner scanner = new Scanner(System.in);
        int option3 = getInt(scanner, 1, 6);

        //scanner.nextLine();

        if (option3 == 1) {

            task.setTitle(scanner.nextLine());
        } else if (option3 == 2) {
            task.setDescription(scanner.nextLine());
        } else if (option3 == 3) {
            task.setPriorities(scanner.nextInt());
        } else if (option3 == 4) {
            task.setPersonResponsible(scanner.nextLine());
        } else if (option3 == 5) {
            task.setData(scanner.nextLine());
        } else if (option3 == 6) {
            task.setTaskFinished(scanner.hasNextBoolean());
        } else System.out.println("Liczba z poza zakresu");

    }


    public void userAddTask() {
        while (true) {
            try {
                String title, description, data, personResponsible;
                int priorities;
                boolean isEnd;
                System.out.println("Podaj tytuł zadania");
                Scanner scanner = new Scanner(System.in);
                title = scanner.nextLine();

                System.out.println("Dodaj opis");
                description = scanner.nextLine();

                System.out.println("Wybierz priorytet w skali od 1 do 10");
                getInt(scanner, 0, 10);
                priorities = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Wybierz termin ukończenia zadania");
                data = scanner.nextLine(); // jak wstawić datę?

                System.out.println("Podaj nazwisko osoby odpowiedzialnej");
                personResponsible = scanner.nextLine();

                System.out.println("Zadanie ukończone?");
                isEnd = scanner.nextBoolean();
                scanner.nextLine();

                addTask(title, description, data, personResponsible, priorities, isEnd);
            } catch (InputMismatchException e) {
                System.out.println("Błędne dane");

            }
            break;
        }


    }

    public void addTask(String title, String description, String data, String personResponsible, int priorities, boolean isEnd) {
        Task newTask = new Task(title, description, priorities, data, personResponsible, isEnd);
        taskList.add(newTask);
        saveTaskToFile(newTask);

    }

    public void printList(Comparator comparator) {
        //taskList.sort(Comparator.comparing(Task::getTitle));
        taskList.sort(comparator);
        System.out.println(taskList);
    }


    public static int getInt(Scanner scanner, int from, int to) {
        int result = getInt(scanner);
        while (result < from || result > to) {
            System.out.println("liczba z poza zakresu!");
            System.out.println("podaj od " + from + " do " + to);
            result = getInt(scanner);
        }
        return result;
    }

    public static int getInt(Scanner scanner) {
        try {
            while (!scanner.hasNextInt()) {
                System.out.println("podaj liczbę:");
                scanner.next();
            }

        } catch (InputMismatchException e) {
            System.out.println("Podaj liczbę");
        }
        return scanner.nextInt();
    }
}



