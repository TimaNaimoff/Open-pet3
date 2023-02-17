package edu.tampa.open_pet3.services;

import edu.tampa.open_pet3.model.User;
import edu.tampa.open_pet3.model.UserMeal;
import edu.tampa.open_pet3.util.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMealService {
    UserMeal save(UserMeal user);
    void delete(int id)throws NotFoundException;
    UserMeal get(int id)throws NotFoundException;
    List<UserMeal>index();

}
