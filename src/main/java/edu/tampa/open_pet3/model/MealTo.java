package edu.tampa.open_pet3.model;


import java.time.LocalDateTime;

public class MealTo {
    protected final LocalDateTime localDateTime;
    protected final String description;
    protected final int calories;
    protected boolean exceed;
    public MealTo(LocalDateTime localDateTime, String description, int calories, boolean exceed){
        this.localDateTime=localDateTime;
        this.description=description;
        this.calories=calories;
        this.exceed=exceed;
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

    public boolean isExceed() {
        return exceed;
    }
    public void setExceed(boolean exceed){
        this.exceed=exceed;
    }

    @Override
    public String toString() {
        return "UserMealWithExceed{" +
                "localDateTime=" + localDateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", exceed=" + exceed +
                '}';
    }
}
