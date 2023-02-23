package edu.tampa.open_pet3.model;

import java.time.LocalDateTime;
import java.util.Objects;

//<<<<<<< HEAD:src/main/java/edu/tzzzzzzzampa/open_pet3/model/UserMeal.java

public class UserMeal {
    protected Integer mealId;
    protected LocalDateTime localDateTime;
    protected String description;
    protected int calories;
    public UserMeal(){

    }
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
        return mealId == null;
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

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMeal that = (UserMeal) o;
        return Objects.equals(mealId, that.mealId);
    }

    @Override
    public int hashCode() {
        return mealId==null?0:mealId;
    }

    @Override
    public String toString() {
        return "UserMeal{" +
                "mealId=" + mealId +
                ", localDateTime=" + localDateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
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
