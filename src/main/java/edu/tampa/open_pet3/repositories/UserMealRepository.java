package edu.tampa.open_pet3.repositories;


import edu.tampa.open_pet3.model.UserMeal;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public interface UserMealRepository {
   // null if updated meal do not belong to userId
   UserMeal save(UserMeal meal,Integer userId);
   // false if meal do not belong to userId

    boolean delete(int id, int userId);

    // null if updated meal do not belong to userId
   UserMeal get(int userId,int mealId);
   // ORDERED DATE, TIME
   Collection<UserMeal> getAll(int userID);
   // ORDERED DATE, TIME
   Collection<UserMeal> getBetween(LocalDateTime startDateTime, LocalDateTime endLocalDateTime, int userId);
 }
