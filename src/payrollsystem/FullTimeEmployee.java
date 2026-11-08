package payrollsystem;

import java.time.LocalDate;

public class FullTimeEmployee extends Employee {
private double allowance;

public FullTimeEmployee(String id, String name, double baseSalary, LocalDate joinDate, double allowance) {
    super(id, name, baseSalary, joinDate);
    this.allowance = allowance;
}

@Override
public double calculateNetSalary() {
    return (baseSalary + allowance) - calculateTax();
}

@Override
public double calculateBonus(double performanceScore) {
    if (performanceScore >= 4.0) {
        return baseSalary * 0.10;
    }
    return 0.0;
}

public double getAllowance() {
    return allowance;
}

public void setAllowance(double allowance) {
    this.allowance = allowance;
}
}