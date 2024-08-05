package entities;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private Integer payDay;

    private Address address;

    private List<Employee> employees = new ArrayList<>();

    public Department() {
    }

    public Department(String name, Integer payDay, Address address) {
        this.name = name;
        this.payDay = payDay;
        this.address = address;
    }

    public Object getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPayDay() {
        return payDay;
    }

    public void setPayDay(Integer payDay) {
        this.payDay = payDay;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        getEmployees().add(employee);
    }

    private void removeEmployee(Employee employee) {
        getEmployees().remove(employee);
    }

    public Double payroll() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }
}
