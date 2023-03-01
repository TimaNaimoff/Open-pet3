package edu.tampa.open_pet3.repositories.jpa;

import edu.tampa.open_pet3.model.User;
import edu.tampa.open_pet3.model.UserMeal;
import edu.tampa.open_pet3.repositories.UserMealRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository("jpaUserMealRepository")
public class JpaUserMealRepository implements UserMealRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public UserMeal save(UserMeal meal, Integer userId) {
        User ref=entityManager.getReference(User.class,userId);
        meal.setUser(ref);
        if(meal.isNew()){
            entityManager.persist(meal);
        }else{
            if(get(userId,meal.getMealId())==null)return null;
            entityManager.merge(meal);
        }
        return meal;
    }

    @Override
    @Transactional
    public boolean delete(int id, int userId) {
        User user=entityManager.find(User.class,userId);
        UserMeal userMeal=entityManager.find(UserMeal.class,id);
        user.getMeals().remove(userMeal);
//        entityManager.createNamedQuery(UserMeal.DELETE).setParameter("mealId",id).setParameter("userId",userId);
        return userMeal.isNew();
    }

    @Override
    public UserMeal get(int userId, int mealId) {
        List<UserMeal> uMeal= entityManager.createNamedQuery(UserMeal.GET).setParameter("mealId",mealId).setParameter("userId",userId).getResultList();
        return uMeal.size()==0?null: DataAccessUtils.requiredSingleResult(uMeal);
    }

    @Override
    public Collection<UserMeal> getAll(int userID) {
        List<UserMeal>meals =  entityManager.createNamedQuery(UserMeal.ALL_SORTED).setParameter("userId",userID).getResultList();
        System.out.println(meals);
        return meals;
    }

    @Override
    public Collection<UserMeal> getBetween(LocalDateTime startDateTime, LocalDateTime endLocalDateTime, int userId) {
        return null;
    }
}
