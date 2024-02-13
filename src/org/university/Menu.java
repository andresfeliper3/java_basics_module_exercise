package org.university;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Menu {
    private University university;

    public Menu() {
        this.university = new University("My University");
    }


    public void startMenu() {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("*********************************************");
            System.out.println("Select one of the following options:\n 1. Print all the teachers.\n 2. Print all " +
                    "the classes. \n 3. Create a new student. \n 4. Create a new class. \n 5. List all the classes given " +
                    "a student. \n 6. Exit");
            int option;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch(InputMismatchException e) {
                throw new RuntimeException("Invalid input");
            }

            if(option == 1) {
                printAllTeachers();
            }
            else if(option == 2) {
                printAllClasses();
                activateClassesSubmenu(scanner);
            }
            else if(option == 6) {
                break;
            }
        }

    }

    private void printAllTeachers() {
        System.out.println(university.getTeachers());
    }

    private void printAllClasses() {
        List<Class> classes = university.getClasses();
        IntStream.range(0, classes.size())
                .mapToObj(i -> (i + 1) + ". " + classes.get(i).getName() + " - " +
                        classes.get(i).getCode())
                .forEach(System.out::println);
    }

    private void activateClassesSubmenu(Scanner scanner) {
        while(true) {
            System.out.println("*********************************************");
            System.out.println("Enter the number of the class you would like to get more information about. \nEnter (q) to quit this submenu.");
            String option;
            try {
                option = scanner.nextLine();
                if(option.equalsIgnoreCase("q")) break;

            } catch(InputMismatchException e) {
                throw new RuntimeException("Invalid input");
            }
            Class selectedClass = university.getClasses().get(Integer.parseInt(option) - 1);
            System.out.println(selectedClass);
        }
    }
}
