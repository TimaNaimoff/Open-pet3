package edu.tampa.open_pet3.util;

import edu.tampa.open_pet3.model.UserMeal;
import edu.tampa.open_pet3.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserMealService {
    public static List<UserMealWithExceed>filter(){
        return UserMealsUtil.getFilteredMealsWithExceeded(UserMealsUtil.LISTER,LocalTime.of(0,7), LocalTime.of(12,0),2000);
    }
}
