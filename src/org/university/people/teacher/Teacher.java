package org.university.people.teacher;

import org.university.Selectable;

public abstract class Teacher implements Selectable {

    public static final int workWeeks = 4;
    protected String name;
    protected double baseSalaryPerHour;
    protected double totalSalaryPerMonth;
    protected int experienceYears;
    protected double activeHoursPerWeek;

    public Teacher(String name, double baseSalary, int experienceYears, double activeHoursPerWeek) {
        this.name = name;
        this.baseSalaryPerHour = baseSalary;
        this.experienceYears = experienceYears;
        this.activeHoursPerWeek = activeHoursPerWeek;
        this.totalSalaryPerMonth = getTotalSalaryPerMonth();
    }

    public abstract double getTotalSalaryPerMonth();

    public String getName() {
        return name;
    }

    public double getBaseSalaryPerHour() {
        return baseSalaryPerHour;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public double getActiveHoursPerWeek() {
        return activeHoursPerWeek;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", baseSalaryPerHour=" + baseSalaryPerHour +
                ", totalSalaryPerMonth=" + totalSalaryPerMonth +
                ", experienceYears=" + experienceYears +
                ", activeHoursPerWeek=" + activeHoursPerWeek +
                "}\n";
    }

    @Override
    public String getShowableDataToSelectMenu() {
        return name;
    }
}
