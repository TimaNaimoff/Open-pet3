package edu.tampa.open_pet3.repositories.datajpa;

import edu.tampa.open_pet3.model.User;
import edu.tampa.open_pet3.model.UserMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProxyUserMealRepository extends JpaRepository<UserMeal,Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM UserMeal u WHERE u.id=?1")
    int delete(int id);
    @Override
    UserMeal save(UserMeal userMeal);
    @Query("FROM UserMeal u WHERE u.id=?1")
    @Override
    UserMeal getOne(Integer id);
    @Query("FROM User u ORDER BY u.name")
    List<User> findAllMeals();

}
