package edu.tampa.open_pet3.repositories;


import edu.tampa.open_pet3.model.UserMeal;

import java.util.Collection;

public interface UserMealRepository {
   UserMeal save(UserMeal meal);
   void delete(int id);
   UserMeal get(int id);
   Collection<UserMeal> getAll();
 }
