package entity;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "employee_id", unique = true)
    private String employeeId;

    @Enumerated(value = EnumType.STRING)
    private EmployeeStatus employeeStatus;

    public Employee() {
    }

    public Employee(String name, String employeeId, EmployeeStatus employeeStatus) {
        this.name = name;
        this.employeeId = employeeId;
        this.employeeStatus = employeeStatus;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", employeeStatus=" + employeeStatus +
                '}';
    }
}
