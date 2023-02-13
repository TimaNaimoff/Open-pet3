package edu.tampa.open_pet3.model;


import java.time.LocalDateTime;

public class UserMealWithExceed {
    protected Integer id;
    protected final LocalDateTime localDateTime;
    protected final String description;
    protected final int calories;
    protected boolean exceed;
    public UserMealWithExceed(Integer id,LocalDateTime localDateTime,String description,int calories,boolean exceed){
        this.id=id;
        this.localDateTime=localDateTime;
        this.description=description;
        this.calories=calories;
        this.exceed=exceed;
    }
    public UserMealWithExceed(LocalDateTime localDateTime,String description,int calories,boolean exceed){
        this.localDateTime=localDateTime;
        this.description=description;
        this.calories=calories;
        this.exceed=exceed;
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
