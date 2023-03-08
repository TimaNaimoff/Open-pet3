package edu.tampa.open_pet3.repositories.datajpa;

import edu.tampa.open_pet3.model.User;
import edu.tampa.open_pet3.model.UserMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProxyUserMealRepository extends JpaRepository<UserMeal,Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM UserMeal u WHERE u.mealId=:id AND u.user.id=:userId")
    int delete(@Param("id") int id,@Param("userId")int userId);
    @Query("FROM User u ORDER BY u.name")
    List<User> findAllMeals();
    @Query("SELECT m FROM UserMeal m WHERE m.id=:id AND m.user.id=:userId")
    UserMeal get(@Param("id")int id,@Param("userId")int userId);
    @Query("SELECT m FROM UserMeal m WHERE m.user.id=:userId")
    List<UserMeal>getAll(@Param("userId")int userId);
    @Query("SELECT m FROM UserMeal m JOIN FETCH um.user WHERE m.id=?1 and m.user.id=?2 ORDER BY m.localDateTime " +
            "DESC")
    UserMeal getWithUser(Integer id,Integer userId);

}
