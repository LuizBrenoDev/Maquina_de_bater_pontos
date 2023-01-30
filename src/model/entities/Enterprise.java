package model.entities;

import java.time.LocalTime;

public class Enterprise {
    private String name;
    private Integer id = hashCode();
    private LocalTime arrival;
    private LocalTime leaving;
    public Enterprise() {
    }

    public Enterprise(String name, LocalTime arrival, LocalTime leaving) {
        this.name = name;
        this.id = id;
        this.arrival = arrival;
        this.leaving = leaving;
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
    public void setArrival(LocalTime arrival) {
        this.arrival = arrival;
    }

    public LocalTime getLeaving() {
        return leaving;
    }
    public void setLeaving(LocalTime leaving) {
        this.leaving = leaving;
    }

    public Integer getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Enterprise: " + getName() + "\n" +
                "Enterprise ID: " + getId() + "\n";
    }
}
