package edu.tampa.open_pet3.repositories;

import edu.tampa.open_pet3.model.UserMeal;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static edu.tampa.open_pet3.repositories.mock.InMemoryUserRepository.ADMIN_ID;
import static edu.tampa.open_pet3.repositories.mock.InMemoryUserRepository.USER_ID;

@Repository("inMemoryUserMealRepository")
public class InMemoryUserMealRepository implements UserMealRepository{
    private Map<Integer,Map<Integer,UserMeal>>repository=new ConcurrentHashMap<>();
    private AtomicInteger count=new AtomicInteger(0);
    public static final Comparator<UserMeal>USER_MEAL_COMPARATOR=((um,um2)->um2.getLocalDateTime().compareTo(um.getLocalDateTime()));
    {
        save(new UserMeal(1,LocalDateTime.of(2015, Month.MAY,30,10,0),"Завтрак",500),USER_ID);
        save(new UserMeal(2,LocalDateTime.of(2015, Month.MAY,30,13,0),"Обед",1000),USER_ID);
        save(new UserMeal(3,LocalDateTime.of(2015, Month.MAY,30,20,0),"Ужин",500),USER_ID);
        save(new UserMeal(4,LocalDateTime.of(2015, Month.MAY,31,10,0),"Завтрак",1000),USER_ID);
        save(new UserMeal(5,LocalDateTime.of(2015, Month.MAY,31,13,0),"Обед админа",500),ADMIN_ID);
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY,31,20,0),"Ужин админа",510),ADMIN_ID);

    }
    @Override
    public UserMeal save(UserMeal meal,Integer userId) {
        Integer mealId=meal.getMealId();
        if(meal.isNew()){
            mealId=count.incrementAndGet();
            meal.setMealId(mealId);
        }else if(get(mealId,userId)==null){
            return null;
        }
        Map<Integer,UserMeal>userMeals=repository.computeIfAbsent(userId,ConcurrentHashMap::new);
        userMeals.put(userId,meal);
        return meal;
    }

    @Override
    public boolean delete(int id, int userId) {
        Map<Integer,UserMeal>userMeals=repository.get(userId);
        return userMeals.remove(id)==null;
    }
    @Override
    public UserMeal get(int userId,int mealId) {
        Map<Integer,UserMeal>userMealMap=repository.get(userId);
        return userMealMap==null?null:userMealMap.get(mealId);
    }

    @Override
    public Collection<UserMeal> getAll(int userID) {
        return repository.get(userID).values();
    }

    @Override
    public Collection<UserMeal> getBetween(LocalDateTime startDateTime, LocalDateTime endLocalDateTime, int userId) {
        return getAll(userId).stream().filter(i->i.getLocalDateTime().isAfter(startDateTime)&&i.getLocalDateTime().isBefore(endLocalDateTime)).sorted(USER_MEAL_COMPARATOR).collect(Collectors.toList());
    }
    public boolean clear(){
        repository.clear();
        return repository==null;
    }

    public void update(int userId,UserMeal meal) {
        Map<Integer,UserMeal> map=new ConcurrentHashMap<>();
        map.put(meal.getMealId(),meal);
        repository.put(userId,map);
    }
}
