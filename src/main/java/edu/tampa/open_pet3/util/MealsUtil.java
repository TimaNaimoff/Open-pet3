//package edu.tampa.open_pet3.util;
//
//import edu.tampa.open_pet3.model.Meal;
//import edu.tampa.open_pet3.model.MealTo;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.Month;
//import java.util.concurrent.*;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
//public class MealsUtil {
//    public static final int DEFAULT_CALORIES_PER_DAY = 2000;
//    public static final List<Meal> MEALS = Arrays.asList(
//            new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
//            new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
//            new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
//            new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
//            new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
//            new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
//    );
//
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        List<Meal> meals = Arrays.asList(
//                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
//                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
//                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
//                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
//                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
//                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
//        );
//        LocalTime startTime = LocalTime.of(7, 0);
//        LocalTime endTime = LocalTime.of(12, 0);
//
//
//        List<MealTo> mealsTo = getFiltered(meals, startTime, endTime,DEFAULT_CALORIES_PER_DAY, meal->true);
//        mealsTo.forEach(System.out::println);
//    }
//
//
//    public static List<MealTo> getFiltered(List<Meal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay, Predicate<Meal> filter) {
//        Map<LocalDate, Integer> caloriesSumByDate = meals.stream()
//                .collect(
//                        Collectors.groupingBy(Meal::getDate, Collectors.summingInt(Meal::getCalories))
//                        //                      Collectors.toMap(Meal::getDate, Meal::getCalories, Integer::sum)
//                );
//        return meals.stream()
//                                .filter(meal -> TimeUtil.isBetween(meal.getTime(), startTime, endTime))
//                                .filter(filter)
//                .map(meal -> createTo(meal, caloriesSumByDate.get(meal.getDate()) > caloriesPerDay))
//                .collect(Collectors.toList());
//    }
//    private static MealTo createTo(Meal meal, boolean excess) {
//        return new MealTo(meal.getDateTime(), meal.getDescription(), meal.getCalories(), excess);
//    }
//
//
//}