package edu.tampa.open_pet3.repositories;

import edu.tampa.open_pet3.model.UserMeal;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository("inMemoryUserMealRepository")
public class InMemoryUserMealRepository implements UserMealRepository{
    private Map<Integer,UserMeal> repository=new ConcurrentHashMap<>();
    private AtomicInteger count=new AtomicInteger(0);
    {
        save(new UserMeal(1,LocalDateTime.of(2015, Month.MAY,30,10,0),"Завтрак",500));
        save(new UserMeal(2,LocalDateTime.of(2015, Month.MAY,30,13,0),"Обед",1000));
        save(new UserMeal(3,LocalDateTime.of(2015, Month.MAY,30,20,0),"Ужин",500));
        save(new UserMeal(4,LocalDateTime.of(2015, Month.MAY,31,10,0),"Завтрак",1000));
        save(new UserMeal(5,LocalDateTime.of(2015, Month.MAY,31,13,0),"Обед",500));
        save(new UserMeal(LocalDateTime.of(2015, Month.MAY,31,20,0),"Ужин",510));

    }
    @Override
    public UserMeal save(UserMeal meal) {
        if(meal.isNew()){
            meal.setMealId(count.incrementAndGet());
        }
        return repository.put(meal.getMealId(),meal);
    }

    @Override
    public void delete(int id) {
        repository.remove(id);
    }


    @Override
    public UserMeal get(int id) {
        return repository.get(id);
    }

    @Override
    public Collection<UserMeal> getAll() {
        return new ArrayList<>(repository.values());
    }
}
