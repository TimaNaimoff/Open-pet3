package edu.tampa.open_pet3.model;

import java.time.LocalDateTime;


public class UserMeal {
    protected Integer mealId;
    protected final LocalDateTime localDateTime;
    protected final String description;
    protected final int calories;
    public UserMeal(Integer id,LocalDateTime localDateTime,String description,int calories){
        this.localDateTime=localDateTime;
        this.description=description;
        this.calories=calories;
        this.mealId =id;
    }
    public UserMeal(LocalDateTime localDateTime,String description,int calories){
        this.localDateTime=localDateTime;
        this.description=description;
        this.calories=calories;
    }
    public boolean isNew(){
        return mealId ==null;
    }
    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
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
                "id=" + mealId +
                ", localDateTime=" + localDateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }
}
