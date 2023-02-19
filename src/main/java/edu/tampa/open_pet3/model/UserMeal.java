package edu.tampa.open_pet3.model;

import java.time.LocalDateTime;

//<<<<<<< HEAD:src/main/java/edu/tzzzzzzzampa/open_pet3/model/UserMeal.java

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
    //=======
//public class Meal {
//    protected final LocalDateTime dateTime;
//    protected final String description;
//    protected final int calories;
//
//    public Meal(LocalDateTime dateTime , String description, int calories){
//        this.dateTime=dateTime;
//        this.description=description;
//        this.calories=calories;
//    }
//    public LocalDateTime getDateTime(){
//        return dateTime;
//    }
//    public LocalDate getDate() {
//        return dateTime.toLocalDate();
//    }
//    public LocalTime getTime() {
//        return dateTime.toLocalTime();
//>>>>>>> main:src/main/java/edu/tampa/open_pet3/model/UserMeal.java
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public int getCalories() {
//        return calories;
//    }
//
//    @Override
//    public String toString() {
//<<<<<<< HEAD:src/main/java/edu/tampa/open_pet3/model/UserMeal.java
//        return "UserMeal{" +
//                "id=" + mealId +
//                ", localDateTime=" + localDateTime +
//=======
//        return "Meal{ " +
//                "localDateTime=" + dateTime +
//>>>>>>> main:src/main/java/edu/tampa/open_pet3/model/UserMeal.java
//                ", description='" + description + '\'' +
//                ", calories=" + calories +
//                '}';
    }
//}
