package org.university;

import java.util.ArrayList;
import java.util.List;

public class Class {
    private String name;
    private String code;
    private String classroom;
    private List<Student> students;
    private Teacher teacher;

    public Class(String name, String code) {
        this.name = name;
        this.code = code;
        this.students = new ArrayList<>();
    }

    public void assignClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addStudents(List<Student> students) {
        this.students.addAll(students);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getClassroom() {
        return classroom;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Teacher getTeacher() {
        return teacher;
    }


}

