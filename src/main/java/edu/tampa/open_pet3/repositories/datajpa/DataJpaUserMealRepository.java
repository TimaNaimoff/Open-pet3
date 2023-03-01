package edu.tampa.open_pet3.repositories.datajpa;

import edu.tampa.open_pet3.model.User;
import edu.tampa.open_pet3.model.UserMeal;
import edu.tampa.open_pet3.repositories.UserMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public class DataJpaUserMealRepository  implements UserMealRepository  {
    @Autowired
    private ProxyUserMealRepository proxyUserMealRepository;
    @Autowired
    private ProxyUserRepository proxyUserRepository;

    @Override
    public UserMeal save(UserMeal meal, Integer userId) {
        User user=proxyUserRepository.getOne(userId);
        user.getMeals().add(meal);
        return proxyUserMealRepository.save(meal);
    }

    @Override
    public boolean delete(int id, int userId) {
        return proxyUserMealRepository.delete(id)!=0;
    }

    @Override
    public UserMeal get(int userId, int mealId) {
        return proxyUserMealRepository.getOne(mealId);
    }

    @Override
    public Collection<UserMeal> getAll(int userID) {
        return proxyUserMealRepository.findAll();
    }

    @Override
    public Collection<UserMeal> getBetween(LocalDateTime startDateTime, LocalDateTime endLocalDateTime, int userId) {
        return null;
    }
}
