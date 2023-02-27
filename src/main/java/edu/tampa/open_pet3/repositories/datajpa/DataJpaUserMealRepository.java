package edu.tampa.open_pet3.repositories.datajpa;

import edu.tampa.open_pet3.model.UserMeal;
import edu.tampa.open_pet3.repositories.UserMealRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public class DataJpaUserMealRepository  implements UserMealRepository  {

    @Override
    public UserMeal save(UserMeal meal, Integer userId) {
        return null;
    }

    @Override
    public boolean delete(int id, int userId) {
        return false;
    }

    @Override
    public UserMeal get(int userId, int mealId) {
        return null;
    }

    @Override
    public Collection<UserMeal> getAll(int userID) {
        return null;
    }

    @Override
    public Collection<UserMeal> getBetween(LocalDateTime startDateTime, LocalDateTime endLocalDateTime, int userId) {
        return null;
    }
}
