package edu.tampa.open_pet3.model;

import java.time.LocalDateTime;

public class UserMeal {
    protected Integer id;
    protected final LocalDateTime localDateTime;
    protected final String description;
    protected final int calories;
    public UserMeal(Integer id,LocalDateTime localDateTime,String description,int calories){
        this.localDateTime=localDateTime;
        this.description=description;
        this.calories=calories;
        this.id=id;
    }
    public UserMeal(LocalDateTime localDateTime,String description,int calories){
        this.localDateTime=localDateTime;
        this.description=description;
        this.calories=calories;
    }
    public boolean isNew(){
        return id==null;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "UserMeal{ " +
                "id="+id+
                "localDateTime=" + localDateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }
}
