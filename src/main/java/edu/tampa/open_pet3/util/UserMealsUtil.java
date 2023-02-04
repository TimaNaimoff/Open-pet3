package edu.tampa.open_pet3.util;

import edu.tampa.open_pet3.model.UserMeal;
import edu.tampa.open_pet3.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> lister = List.of(
                new UserMeal(LocalDateTime.of(2023, Month.MARCH,30,10,0),"Завтрак",500),
                new UserMeal(LocalDateTime.of(2023, Month.MARCH,30,13,0),"Обед",500),
                new UserMeal(LocalDateTime.of(2023, Month.MARCH,30,20,0),"Ужин",500),
                new UserMeal(LocalDateTime.of(2023, Month.MARCH,30,10,0),"Завтрак",500),
                new UserMeal(LocalDateTime.of(2023, Month.MARCH,30,13,0),"Обед",500),
                new UserMeal(LocalDateTime.of(2023, Month.MARCH,30,20,0),"Ужин",500)

        );
        System.out.println(getFilteredMealsWithExceeded(lister,LocalTime.of(0,7), LocalTime.of(12,0),2000));
    }

    private static List<UserMealWithExceed> getFilteredMealsWithExceeded(List<UserMeal> lister, LocalTime of, LocalTime of1, int i) {
        Map<LocalDate, Integer> caloriesSumByDate = lister.stream().collect(Collectors.groupingBy
                (u -> u.getLocalDateTime().toLocalDate(),Collectors.summingInt(UserMeal::getCalories)));
        return lister.stream().
                filter(e->e.getLocalDateTime().toLocalTime().isAfter(of)&&e.getLocalDateTime().toLocalTime().
                        isBefore(of1)).map(e->new UserMealWithExceed(e.getLocalDateTime(),e.getDescription(),e.getCalories(),caloriesSumByDate.get(e.getLocalDateTime().toLocalDate())>i)).collect(Collectors.toList());

    }
}
