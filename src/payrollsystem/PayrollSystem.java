package payrollsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PayrollSystem {
public static void main(String[] args) {
ArrayList<Employee> employees = new ArrayList<Employee>();

    employees.add(new FullTimeEmployee("FT01", "Ahmed Ali", 4000.0, LocalDate.of(2021, 5, 10), 500.0));
    employees.add(new FullTimeEmployee("FT02", "Maryam Omar", 5000.0, LocalDate.of(2019, 3, 15), 600.0));
    employees.add(new ContractorEmployee("CT01", "Khaled Hassan", LocalDate.of(2023, 1, 20), 50, 70));
    employees.add(new ContractorEmployee("CT02", "Sara Tarek", LocalDate.of(2022, 8, 5), 60, 80));

   Collections.sort(employees,new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
       return Double.compare(e2.calculateNetSalary(), e1.calculateNetSalary());
        }
   });
    System.out.println("--- Employees Sorted By Net Salary (Descending) ---");
    for (Employee e : employees) {
        System.out.println(e);
      System.out.println();   
    }

    Collections.sort(employees,new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getJoinDate().compareTo(e2.getJoinDate());
        }
    });
    System.out.println("\n--- Employees Sorted By Join Date ---");
    for (Employee e : employees) {
        System.out.println(e);
         System.out.println();
    }

    double totalTax = 0;
    double totalBonus = 0;
    for (Employee e : employees) {
        totalTax += e.calculateTax();
        if(e instanceof FullTimeEmployee){
        totalBonus +=((FullTimeEmployee)e).calculateBonus(4.5);
    }else if(e instanceof ContractorEmployee){
      totalBonus +=((ContractorEmployee)e).calculateBonus(4.5);   
    }
    }
    System.out.println("\n--- System Statistics ---");
    System.out.println("Total Tax: " + totalTax);
    System.out.println("Total Bonus: " + totalBonus);
}
}
