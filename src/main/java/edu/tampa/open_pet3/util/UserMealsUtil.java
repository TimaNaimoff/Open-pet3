package edu.tampa.open_pet3.util;

import edu.tampa.open_pet3.model.UserMeal;
import edu.tampa.open_pet3.to.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class UserMealsUtil {
    public static final List<UserMeal> LISTER = List.of(
            new UserMeal(LocalDateTime.of(2023, Month.MARCH,30,10,0),"Завтрак",500),
            new UserMeal(LocalDateTime.of(2023, Month.MARCH,30,13,0),"Обед",500),
            new UserMeal(LocalDateTime.of(2023, Month.MARCH,30,20,0),"Ужин",500),
            new UserMeal(LocalDateTime.of(2023, Month.MARCH,30,10,0),"Завтрак",500),
            new UserMeal(LocalDateTime.of(2023, Month.MARCH,30,13,0),"Обед",500),
            new UserMeal(LocalDateTime.of(2023, Month.MARCH,30,20,0),"Ужин",500)

    );


    public static List<UserMealWithExceed> getFilteredMealsWithExceeded(List<UserMeal> betweenDates, LocalTime startTime, LocalTime endTime, int id) {
        return betweenDates.stream().filter(e->e.getLocalDateTime().toLocalTime().isAfter(startTime)&&e.getMealId()==id&&e.getLocalDateTime().toLocalTime().isBefore(endTime)).map(meal->createTo(meal,meal.getCalories()<id)).collect(Collectors.toList());
    }
    private static UserMealWithExceed createTo(UserMeal meal, boolean excess) {
        return new UserMealWithExceed(meal.getMealId(),meal.getLocalDateTime(), meal.getDescription(), meal.getCalories(), excess);
    }
}
