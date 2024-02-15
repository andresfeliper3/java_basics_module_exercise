package org.university.menu;

import org.university.University;
import org.university.classes.Class;
import org.university.people.Student;
import org.university.people.teacher.Teacher;

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
            else if(option == 3) {
                activateStudentCreationSubmenu(scanner);
            }
            else if(option == 4) {
                activateClassCreationSubmenu(scanner);
            }
            else if(option == 5) {
                printClassesByStudent(scanner);
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

    private void printAllStudents() {
        System.out.println(university.getStudents());
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

    private void activateStudentCreationSubmenu(Scanner scanner) {
        System.out.println("*********************************************");
        try {
            System.out.println("Enter the student name:");
            String name = scanner.nextLine();
            System.out.println("Enter the student id:");
            String id = scanner.nextLine();

            int age = getValidAge(scanner);

            Student newStudent = new Student(name, id, age);
            university.createStudent(newStudent);

            Class assignedClass = getValidClass(scanner);
            university.addStudentToClass(newStudent, assignedClass);

            System.out.println("Successfully added");

        } catch (InputMismatchException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private int getValidAge(Scanner scanner) {
        while (true) {
            System.out.println("Enter the student age:");
            try {
                int age = scanner.nextInt();
                if (age <= 0) {
                    System.out.println("Invalid input for student age. Enter a valid age.");
                    continue;
                }
                return age;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for student age. Please enter a valid number.");
            } finally {
                scanner.nextLine();
            }
        }
    }

    private Class getValidClass(Scanner scanner) {
        while (true) {
            printAllClasses();
            System.out.println("Enter the number of the class you would like to add the new student to.");
            try {
                int classNumber = scanner.nextInt();
                //if the class number entered is negative or exceeds the amount of classes, ask for entering again
                if (classNumber <= 0 || classNumber > university.getClasses().size()) {
                    System.out.println("Invalid input for class number. Enter a valid number.");
                    continue;
                }
                return university.getClasses().get(classNumber - 1);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for class number. Enter a valid number.");
            } finally {
                scanner.nextLine();
            }
        }
    }

    private Teacher getValidTeacher(Scanner scanner) {
        while (true) {
            printAllTeachersToSelect();
            System.out.println("Enter the number of the teacher you would like to add.");
            try {
                int teacherNumber = scanner.nextInt();
                //if the class number entered is negative or exceeds the amount of classes, ask for entering again
                if (teacherNumber <= 0 || teacherNumber > university.getTeachers().size()) {
                    System.out.println("Invalid input for teacher number. Enter a valid number.");
                    continue;
                }
                return university.getTeachers().get(teacherNumber - 1);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for teacher number. Enter a valid number.");
            } finally {
                scanner.nextLine();
            }
        }
    }

    private Student getValidStudent(Scanner scanner) {
        while (true) {
            printAllStudents();
            System.out.println("Enter the number of the student you would like to add.");
            try {
                int studentNumber = scanner.nextInt();
                //if the class number entered is negative or exceeds the amount of classes, ask for entering again
                if (studentNumber <= 0 || studentNumber > university.getTeachers().size()) {
                    System.out.println("Invalid input for student number. Enter a valid number.");
                    continue;
                }
                return university.getStudents().get(studentNumber - 1);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for student number. Enter a valid number.");
            } finally {
                scanner.nextLine();
            }
        }
    }

    private void activateClassCreationSubmenu(Scanner scanner) {
        System.out.println("*********************************************");
        System.out.println("Enter the class name");
        String className = scanner.nextLine();

        System.out.println("Enter the class code");
        String classCode = scanner.nextLine();

        Class newClass = new Class(className, classCode);
        university.createClass(newClass);

        Teacher selectedTeacher = getValidTeacher(scanner);
        university.addTeacherToClass(selectedTeacher, newClass);

        System.out.println("Add existing students to the new class:");
        Student selectedStudent = getValidStudent(scanner);
        university.addStudentToClass(selectedStudent, newClass);

        System.out.println("Type the classroom name of the new class:");
        String classroomName = scanner.nextLine();
        university.addClassroomToClass(classroomName, newClass);

    }

    private void printAllTeachersToSelect() {
        List<Teacher> teachers = university.getTeachers();
        IntStream.range(0, teachers.size())
                .mapToObj(i -> (i + 1) + ". " + teachers.get(i).getName())
                .forEach(System.out::println);
    }


    private void printClassesByStudent(Scanner scanner) {
        System.out.println("*********************************************");
        while (true) {
            printAllStudents();
            System.out.println("Enter the ID of the student whose classes you would like to see.");
            String studentId = scanner.nextLine();
            try {
                Student studentSelected = university.searchStudentById(studentId);
                for (Class aClass : studentSelected.getAssignedClasses()) {
                    System.out.println(aClass.getName() + " - " + aClass.getCode());
                }
                break; // valid classes have been printed
            } catch (RuntimeException e) {
                System.out.println("Invalid student ID. Please enter a valid student ID:");
            }
        }
    }
}
