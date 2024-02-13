package org.university;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String id;
    private int age;
    private List<Class> assignedClasses;

    public Student(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
        assignedClasses = new ArrayList<>();
    }

    public void assignClasses(List<Class> classes){
        assignedClasses.addAll(classes);
    }

    public void assignClass(Class aClass) {
        assignedClasses.add(aClass);
    }

    public void removeClasses() {
        assignedClasses.clear();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Class> getAssignedClasses() {
        return assignedClasses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
