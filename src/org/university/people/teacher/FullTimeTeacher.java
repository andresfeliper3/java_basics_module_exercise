package org.university.people.teacher;

public class FullTimeTeacher extends Teacher {

    public FullTimeTeacher(String name, double baseSalary, int experienceYears) {
        super(name, baseSalary, experienceYears, 48);
    }

    @Override
    public double getTotalSalaryPerMonth() {
        totalSalaryPerMonth = (baseSalaryPerHour * activeHoursPerWeek) * Teacher.workWeeks * (1.1 * experienceYears);
        return totalSalaryPerMonth;
    }
}
