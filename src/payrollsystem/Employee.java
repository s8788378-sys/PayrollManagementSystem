package payrollsystem;

import java.time.LocalDate;

public abstract class Employee implements Comparable,Taxable, BonusCalculable {
private String id;
private String name;
protected double baseSalary;
private LocalDate joinDate;

public Employee(String id, String name, double baseSalary, LocalDate joinDate) {
    this.id = id;
    this.name = name;
    this.baseSalary = baseSalary;
    this.joinDate = joinDate;
}

public abstract double calculateNetSalary();

@Override
public double calculateTax() {
    return baseSalary * TAX_RATE;
}
 
@Override
public double calculateBonus(double performanceScore) {
    return baseSalary * 0.1 * performanceScore;
}   

@Override
public int compareTo(Employee other) {
    return Double.compare(other.calculateNetSalary(), this.calculateNetSalary());
}

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public double getBaseSalary() {
    return baseSalary;
}

public void setBaseSalary(double baseSalary) {
    this.baseSalary = baseSalary;
}

public LocalDate getJoinDate() {
    return joinDate;
}

public void setJoinDate(LocalDate joinDate) {
    this.joinDate = joinDate;
}

@Override
public String toString() {
    return "ID: " + id + ", Name: " + name + ", Net Salary: " + calculateNetSalary() + ", Join Date: " + joinDate;
}
}
