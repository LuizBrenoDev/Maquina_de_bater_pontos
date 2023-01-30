package model.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Objects;

public class Employee {
    private String name;
    private Integer id = hashCode();
    private LocalTime arrival = LocalTime.now();
    private LocalTime leaving = LocalTime.now();

    private LocalDate date = LocalDate.now();
    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getArrival() {
        return arrival;
    }
    public LocalTime getLeaving() {
        return leaving;
    }
    public Integer getId() {
        return id;
    }



    public String checkDelay(char reply, Enterprise enterprise){
        String msg = null;
        if(reply == 'a'){
            if(arrival.isAfter(enterprise.getArrival())){
               msg = "\n Arrived after";
            } else if (arrival.isBefore(enterprise.getArrival())) {
               msg = "\n Arrived before";
            }else{
               msg = "\n Arrived in hour";
            }
        }else if(reply == 'l'){
            if(leaving.isAfter(enterprise.getLeaving())){
               msg = "\n Leaved after";
            } else if (leaving.isBefore(enterprise.getLeaving())) {
               msg = "\n Leaved before";
            }else {
               msg = "\n Leaved in hour";
            }
        }else{
            throw new InputMismatchException("Incorrect input");
        }
        return msg;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getName(), employee.getName()) && Objects.equals(getId(), employee.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId());
    }

    @Override
    public String toString() {
        return "Employee: " + name + "\n" +
                "Employee ID: " + getId() + "\n"+
                "Arrived in: " +  getArrival();
    }
}
