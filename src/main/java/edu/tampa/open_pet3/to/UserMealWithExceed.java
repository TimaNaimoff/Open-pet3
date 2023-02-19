package edu.tampa.open_pet3.to;


import java.time.LocalDateTime;

//<<<<<<<< HEAD:src/main/java/edu/tampa/open_pet3/to/UserMealWithExceed.java
public class UserMealWithExceed {
    protected Integer mealId;
//========
//>>>>>>>> main:src/main/java/edu/tampa/open_pet3/model/MealTo.java
    protected final LocalDateTime localDateTime;
    protected final String description;
    protected final int calories;
    protected boolean exceed;
//<<<<<<<< HEAD:src/main/java/edu/tampa/open_pet3/to/UserMealWithExceed.java
    public UserMealWithExceed(Integer id,LocalDateTime localDateTime,String description,int calories,boolean exceed){
        this.mealId =id;
        this.localDateTime=localDateTime;
        this.description=description;
        this.calories=calories;
        this.exceed=exceed;
    }
//    public UserMealWithExceed(LocalDateTime localDateTime,String description,int calories,boolean exceed){
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

    public boolean isExceed() {
        return exceed;
    }
    public void setExceed(boolean exceed){
        this.exceed=exceed;
    }

    @Override
    public String toString() {
        return "UserMealWithExceed{" +
                "id=" + mealId +
                ", localDateTime=" + localDateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", exceed=" + exceed +
                '}';
    }
}
