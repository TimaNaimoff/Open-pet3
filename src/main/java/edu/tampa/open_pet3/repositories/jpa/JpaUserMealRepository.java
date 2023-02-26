package edu.tampa.open_pet3.repositories.jpa;

import edu.tampa.open_pet3.model.UserMeal;
import edu.tampa.open_pet3.repositories.UserMealRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository("jpaUserMealRepository")
@Transactional(readOnly=true)
public class JpaUserMealRepository implements UserMealRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public UserMeal save(UserMeal meal, Integer userId) {
        if(meal.isNew()){
            entityManager.persist(meal);
        }else{
            entityManager.merge(meal);
        }
        return meal;
    }

    @Override
    @Transactional
    public boolean delete(int id, int userId) {
        UserMeal userMeal=entityManager.find(UserMeal.class,id);
        entityManager.remove(userMeal);
        return userMeal.isNew();
    }

    @Override
    public UserMeal get(int userId, int mealId) {
        UserMeal uMeal= entityManager.find(UserMeal.class,userId);
        entityManager.detach(uMeal);
        return uMeal;
    }

    @Override
    public Collection<UserMeal> getAll(int userID) {
        List<UserMeal>meals =  entityManager.createQuery("SELECT m FROM UserMeal m WHERE m.user.id=:userID",UserMeal.class).setParameter("userID",userID).getResultList();
        System.out.println(meals);
        return meals;
    }

    @Override
    public Collection<UserMeal> getBetween(LocalDateTime startDateTime, LocalDateTime endLocalDateTime, int userId) {
        return null;
    }
}
