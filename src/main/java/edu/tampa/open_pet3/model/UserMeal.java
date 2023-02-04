package edu.tampa.open_pet3.model;

import java.time.LocalDateTime;

public class UserMeal {
    protected final LocalDateTime localDateTime;
    protected final String description;
    protected final int calories;
    public UserMeal(LocalDateTime localDateTime,String description,int calories){
        this.localDateTime=localDateTime;
        this.description=description;
        this.calories=calories;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "UserMeal{" +
                "localDateTime=" + localDateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }
}
