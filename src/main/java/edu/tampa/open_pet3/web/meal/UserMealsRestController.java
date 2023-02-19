package edu.tampa.open_pet3.web.meal;

import edu.tampa.open_pet3.LoggedUser;
import edu.tampa.open_pet3.model.UserMeal;
import edu.tampa.open_pet3.to.UserMealWithExceed;
import edu.tampa.open_pet3.services.UserMealServiceImpl;
import edu.tampa.open_pet3.util.UserMealsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import static edu.tampa.open_pet3.repositories.InMemoryUserMealRepository.USER_MEAL_COMPARATOR;

@Controller
public class UserMealsRestController {
    private UserMealServiceImpl userMealService;
    private static final Logger LOG= LoggerFactory.getLogger(UserMealsRestController.class);
    @Autowired
    public UserMealsRestController(UserMealServiceImpl userMealService){
        this.userMealService=userMealService;
    }
    public UserMeal get(int id){
        int userId= LoggedUser.id();
        LOG.info("get meal {} for User {}",id,userId);
        return userMealService.get(id,userId);
    }
    public void delete(int id){
        int userId=LoggedUser.id();
        LOG.info("delete meal {} for User {}",id,userId);
        userMealService.delete(id,userId);
    }
    public List<UserMeal>getAllik(int id){
        return userMealService.index(id);
    }
    public List<UserMealWithExceed> getAll(){

        int userId = LoggedUser.id();
        LOG.info("getAll for User {}",userId);
        return UserMealsUtil.getFilteredMealsWithExceeded(userMealService.index(userId).stream().sorted(USER_MEAL_COMPARATOR).collect(Collectors.toList()),
                LocalTime.MIN,LocalTime.MAX, LoggedUser.getCaloriesPerDay());
    }

    public void deleteAll(){
        int userId=LoggedUser.id();
        LOG.info("deleteAll for User {}",userId);
        userMealService.deleteAll(userId);
    }
    public void update(UserMeal meal){

        int userId=LoggedUser.id();
        LOG.info("update {} for User {}",userId,meal);
        userMealService.update(userId,meal);

    }
    public void create(UserMeal meal){
        int userId=LoggedUser.id();
        LOG.info("creating {} for User {}",userId,meal);
        userMealService.save(userId,meal);
    }
    public List<UserMealWithExceed>getBetween(LocalDate startDate,LocalTime startTime, LocalDate endDate,LocalTime endTime){

        int userId=LoggedUser.id();
        LOG.info("getBetween dates {} - {} for time {} - {} for User {}",
                startDate,startTime,endDate,endTime,userId);
        return UserMealsUtil.getFilteredMealsWithExceeded(userMealService.getBetweenDates(
                startDate,endDate,userId),startTime,endTime,LoggedUser.id());


    }


}
