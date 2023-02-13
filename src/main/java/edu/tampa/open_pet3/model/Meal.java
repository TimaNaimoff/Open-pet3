package edu.tampa.open_pet3.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Meal {
    protected final LocalDateTime dateTime;
    protected final String description;
    protected final int calories;

    public Meal(LocalDateTime dateTime , String description, int calories){
        this.dateTime=dateTime;
        this.description=description;
        this.calories=calories;
    }
    public LocalDateTime getDateTime(){
        return dateTime;
    }
    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }
    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "Meal{ " +
                "localDateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }
}
