package org.university.people.teacher;

public class PartTimeTeacher extends Teacher {
    public PartTimeTeacher(String name, double baseSalary, int experienceYears, double activeHoursPerWeek) {
        super(name, baseSalary, experienceYears, activeHoursPerWeek);
    }

    @Override
    public double getTotalSalaryPerMonth() {
        totalSalaryPerMonth = baseSalaryPerHour * activeHoursPerWeek * Teacher.workWeeks;
        return totalSalaryPerMonth;
    }
}
