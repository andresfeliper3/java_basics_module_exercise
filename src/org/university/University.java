package org.university;

import java.util.List;

public class University {
    private String name;
    private List<Class> classes;
    private List<Student> students;
    private List<Teacher> teachers;

    public University(String name) {
        this.name = name;
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

    public void addStudentToClass(Student student, Class aClass) {
        aClass.addStudent(student);
    }

    public void createTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addTeacherToClass(Teacher teacher, Class aClass) {
        aClass.assignTeacher(teacher);
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
