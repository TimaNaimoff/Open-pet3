package edu.tampa.open_pet3.util;

import edu.tampa.open_pet3.model.UserMeal;
import edu.tampa.open_pet3.model.UserMealWithExceed;

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
    public static void main(String[] args) {

        System.out.println(getFilteredMealsWithExceeded(LISTER,LocalTime.of(0,7), LocalTime.of(12,0),2000));
        System.out.println(getFilteredMealsWithLoops(LISTER,LocalTime.of(0,7), LocalTime.of(12,0),2000));

    }

    public static List<UserMealWithExceed> getFilteredMealsWithExceeded(List<UserMeal> lister, LocalTime of, LocalTime of1, int i) {
        Map<LocalDate, Integer> caloriesSumByDate = lister.stream().collect(Collectors.groupingBy
                (u -> u.getLocalDateTime().toLocalDate(),Collectors.summingInt(UserMeal::getCalories)));
        return lister.stream().
                filter(e->e.getLocalDateTime().toLocalTime().isAfter(of)&&e.getLocalDateTime().toLocalTime().
                        isBefore(of1)).map(e->new UserMealWithExceed(e.getLocalDateTime(),e.getDescription(),e.getCalories(),caloriesSumByDate.get(e.getLocalDateTime().toLocalDate())>i)).collect(Collectors.toList());

    }
    private static List<UserMealWithExceed> getFilteredMealsWithLoops(List<UserMeal> lister,LocalTime of,LocalTime of1,int i){
        int counter=0;
        int ttt=0;

        List<UserMealWithExceed>userMealWithExceeds=new ArrayList<>();
        for(int id=0;id<lister.size();id++){
            if(ttt==0&&lister.get(id).getLocalDateTime().toLocalTime().isAfter(of)&&lister.get(id).getLocalDateTime().toLocalTime().isBefore(of1)){
                counter+=lister.get(id).getCalories();
            }
            if(counter>i&&ttt==0){
                id=0;
                ttt++;
            }
                userMealWithExceeds.add(new UserMealWithExceed(lister.get(id).getLocalDateTime(),lister.get(id).getDescription(),lister.get(id).getCalories(),counter>i));

        }
        return userMealWithExceeds;
    }
}
