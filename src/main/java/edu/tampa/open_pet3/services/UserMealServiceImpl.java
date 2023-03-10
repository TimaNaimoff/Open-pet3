package edu.tampa.open_pet3.services;

import edu.tampa.open_pet3.model.UserMeal;
import edu.tampa.open_pet3.repositories.datajpa.DataJpaUserMealRepository;
import edu.tampa.open_pet3.repositories.jpa.JpaUserMealRepository;
import edu.tampa.open_pet3.to.UserMealWithExceed;
import edu.tampa.open_pet3.repositories.mock.InMemoryUserMealRepository;
import edu.tampa.open_pet3.util.UserMealsUtil;
import edu.tampa.open_pet3.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class UserMealServiceImpl implements UserMealService {
    @Autowired
    @Qualifier("dataJpaUserMealRepository")
    private  DataJpaUserMealRepository mealRepo;
    public static List<UserMealWithExceed>filter(){
        return UserMealsUtil.getFilteredMealsWithExceeded(UserMealsUtil.LISTER,LocalTime.of(0,7), LocalTime.of(12,0),2000);
    }


//    @Override
//    @CacheEvict(value="users",allEntries = true)
//    public void evictCache() {
//
//    }
    @Override
    @Transactional
//    @CacheEvict(value="meals",allEntries=true)
    public UserMeal save(int userId, UserMeal user) {
          mealRepo.save(user,userId);
          return user;
    }

    public DataJpaUserMealRepository getMealRepo() {
        return mealRepo;
    }

    @Override
    @Transactional
//    @CacheEvict(value="meals",allEntries=true)
    public void delete(int id, int userId) throws NotFoundException {
        mealRepo.delete(id,userId);
    }

    @Override
    public UserMeal get(int id, int userId) throws NotFoundException {
        return mealRepo.get(userId,id);
    }

    @Override
//    @Cacheable("meals")
    public List<UserMeal> index(int userId) {
        List<UserMeal> userMeals= (List<UserMeal>) mealRepo.getAll(userId);
        return userMeals==null? Collections.EMPTY_LIST:userMeals;
    }

    @Override
    public List<UserMeal> getBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endTime, int userid) {
        Objects.requireNonNull(startDateTime);
        Objects.requireNonNull(endTime);
        return (List<UserMeal>)mealRepo.getBetween(startDateTime,endTime,userid);
    }

//    @CacheEvict(value="meals",allEntries=true)
    public void update(int userId,UserMeal meal) {
        mealRepo.save(meal,userId);
    }
}
