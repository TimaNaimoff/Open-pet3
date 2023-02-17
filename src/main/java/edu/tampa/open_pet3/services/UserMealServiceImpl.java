package edu.tampa.open_pet3.services;

import edu.tampa.open_pet3.model.UserMeal;
import edu.tampa.open_pet3.model.UserMealWithExceed;
import edu.tampa.open_pet3.repositories.InMemoryUserMealRepository;
import edu.tampa.open_pet3.util.UserMealsUtil;
import edu.tampa.open_pet3.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class UserMealServiceImpl implements UserMealService {
    @Qualifier("inMemoryUserMealRepository")
    private final InMemoryUserMealRepository mealRepo;
    @Autowired
    public UserMealServiceImpl(InMemoryUserMealRepository mealRepo){
        this.mealRepo=mealRepo;
    }
    public static List<UserMealWithExceed>filter(){
        return UserMealsUtil.getFilteredMealsWithExceeded(UserMealsUtil.LISTER,LocalTime.of(0,7), LocalTime.of(12,0),2000);
    }

    @Override
    public UserMeal save(UserMeal user) {
          mealRepo.save(user);
          return user;
    }

    @Override
    public void delete(int id) throws NotFoundException {
        mealRepo.delete(id);
    }

    @Override
    public UserMeal get(int id) throws NotFoundException {
        return mealRepo.get(id);
    }

    @Override
    public List<UserMeal> index() {
        return (List<UserMeal>) mealRepo.getAll();
    }
}
