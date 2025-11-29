/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lastca_algorithm;

/**
 *
 * @author altangerel
 */
public class Employee { //representing employee with all informations

    private final String firstName;
    private final String lastName;
    private final String gender;
    private final String email;
    private final double salary;
    private final String department;
    private final String position;
    private final String jobTitle;
    private final String company;

    public Employee(String firstName, String lastName, String gender, String email,
            double salary, String department, String position, String jobTitle, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.salary = salary;
        this.department = department;
        this.position = position;
        this.jobTitle = jobTitle;
        this.company = company;
    }

    public double getSalary() {
        return salary;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }
    
    @Override
    public String toString() {
        return firstName + "," + lastName + "," + gender + "," + email + ","
                + salary + "," + department + "," + position + "," + jobTitle + "," + company;
    }
    //displaying employee details
    public String display() {
        return firstName + " " + lastName + " | " + gender + " | " + email
                + " | Salary: " + salary + " | Dept: " + department + " | Position: " + position
                + " | Job: " + jobTitle + " | Company: " + company;
    }

}
