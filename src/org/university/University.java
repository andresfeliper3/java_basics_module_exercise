package org.university;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class University {
    private String name;
    private List<Class> classes;
    private List<Student> students;
    private List<Teacher> teachers;

    public University(String name) {
        this.name = name;
        this.classes = new ArrayList<>();
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        initializeUniversity();
    }

    private void initializeUniversity() {
        initializeTeachers();
        initializeStudents();
        initializeClasses();
    }

    private void initializeTeachers() {
        FullTimeTeacher fullTimeTeacher1 = new FullTimeTeacher("Julián Rodríguez", 20000, 5);
        FullTimeTeacher fullTimeTeacher2 = new FullTimeTeacher("Marcela Suárez", 20000, 7);

        PartTimeTeacher partTimeTeacher1 = new PartTimeTeacher("Lorena Peláez", 15000, 2, 20);
        PartTimeTeacher partTimeTeacher2 = new PartTimeTeacher("Miguel López", 15000, 3, 22);

        createTeachers(Arrays.asList(fullTimeTeacher1, fullTimeTeacher2, partTimeTeacher1, partTimeTeacher2));
    }

    private void initializeStudents() {
        Student student1 = new Student("Camilo González", "67854972", 21);
        Student student2 = new Student("Laura Martínez", "78945612", 20);
        Student student3 = new Student("Juan Pérez", "12345678", 22);
        Student student4 = new Student("María López", "45678912", 19);
        Student student5 = new Student("Carlos Ramírez", "98765432", 18);
        Student student6 = new Student("Ana Rodríguez", "65432198", 23);

        createStudents(Arrays.asList(student1, student2, student3, student4, student5, student6));
    }

    private void initializeClasses() {
        Class class1 = new Class("Calculus", "15056M");
        addTeacherToClass(teachers.get(0), class1);
        addClassroomToClass("AUD 4", class1);
        addStudentsToClass(Arrays.asList(students.get(0), students.get(1)), class1);

        Class class2 = new Class("Linear Algebra", "15052M");
        addTeacherToClass(teachers.get(0), class2);
        addClassroomToClass("AUD 1", class2);
        addStudentsToClass(Arrays.asList(students.get(2), students.get(3)), class2);

        Class class3 = new Class("Algorithms", "14067M");
        addTeacherToClass(teachers.get(0), class3);
        addClassroomToClass("AUD 2", class3);
        addStudentsToClass(Arrays.asList(students.get(1), students.get(2), students.get(3), students.get(4), students.get(5)), class3);

        Class class4 = new Class("Data science", "14062M");
        addTeacherToClass(teachers.get(0), class4);
        addClassroomToClass("AUD 7", class4);
        addStudentsToClass(Arrays.asList(students.get(4), students.get(5)), class4);

        createClasses(Arrays.asList(class1, class2, class3, class4));
    }

    public List<Class> searchClassesByStudentId(String id) {
        return searchClassesByStudent(searchStudentById(id));
    }

    public Student searchStudentById(String id) {
        for(Student student : students) {
            if(id.equals(student.getId())) {
                return student;
            }
        }
        return null;
    }

    public List<Class> searchClassesByStudent(Student student) {
        return student.getAssignedClasses();
    }

    public void createClass(Class aClass) {
        classes.add(aClass);
    }

    public void createClasses(List<Class> classes) {
        this.classes.addAll(classes);
    }

    public void addStudentToClass(Student student, Class aClass) {
        aClass.addStudent(student);
    }

    public void addStudentsToClass(List<Student> students, Class aClass) {
        aClass.addStudents(students);
    }

    public void createTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void createTeachers(List<Teacher> teachers) {
        this.teachers.addAll(teachers);
    }

    public void createStudent(Student student) {
        students.add(student);
    }

    public void createStudents(List<Student> students) {
        this.students.addAll(students);
    }

    public void addTeacherToClass(Teacher teacher, Class aClass) {
        aClass.assignTeacher(teacher);
    }

    public void addClassroomToClass(String classroom, Class aClass) {
        aClass.assignClassroom(classroom);
    }

    public String getName() {
        return name;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }
}
