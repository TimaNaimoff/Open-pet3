package edu.tampa.open_pet3.services;

import edu.tampa.open_pet3.model.User;
import edu.tampa.open_pet3.model.UserMeal;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMealTestData {
    public static final Integer USER_MEAL_ID=1;
    public static final Integer USER_MEAL_ID_2=2;
    public static final UserMeal OBJ1=new UserMeal(100000,null,"blablabla",1000);
    public static final UserMeal OBJ2=new UserMeal(100001,null,"Suponius",2000
    );

    public static void assertMatch(UserMeal expected, UserMeal actual){
        assertThat(actual).isEqualToIgnoringGivenFields(expected,"localDateTime","user");
    }
    public static void assertMatch(Iterable<UserMeal>actual,UserMeal...expected){
        assertMatch(actual,Arrays.asList(expected));
    }
    public static void assertMatch(Iterable<UserMeal>actual,Iterable<UserMeal>expected){
        assertThat(actual).isEqualTo(expected);
    }
}
