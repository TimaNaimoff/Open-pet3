package edu.tampa.open_pet3.repositories.jdbc;

import edu.tampa.open_pet3.model.User;
import edu.tampa.open_pet3.model.UserMeal;
import edu.tampa.open_pet3.repositories.UserMealRepository;
import edu.tampa.open_pet3.util.exception.NotFoundException;
import edu.tampa.open_pet3.util.mappers.MealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

@Repository
public class JdbcUserMealRepository implements UserMealRepository {
    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate parameterJdbcTemplate;
    private static final String INSERT_MEALS="INSERT INTO meals(id,local_date_time,description,calories)VALUES(?,?,?,?)";
    private static final String UPDATE_MEALS="UPDATE meals SET local_date_time=?," +
            "description=?,calories=?,id=? WHERE meal_id=?";
//    private SimpleJdbcInsert insertUser;
    private static final String DELETE_MEALS="DELETE FROM meals WHERE id=? AND meal_id=?";
    private static final String GET_ALL="SELECT * FROM meals WHERE id=? ORDER BY local_date_time DESC";
    private static final String GET_MEAL="SELECT * FROM meals WHERE id = ? AND meal_id = ?";
    @Autowired
    public JdbcUserMealRepository(JdbcTemplate jdbcTemplate,NamedParameterJdbcTemplate parameterJdbcTemplate){
//        this.insertUser=new SimpleJdbcInsert(jdbcTemplate).withTableName("meals")
//                .usingGeneratedKeyColumns("mealId");
        this.jdbcTemplate=jdbcTemplate;
        this.parameterJdbcTemplate=parameterJdbcTemplate;
    }


    @Override
    public UserMeal save(UserMeal meal, Integer userId) {
        Assert.notNull(meal,"Object must be null");
        if(meal.isNew()){
            Number newKey=jdbcTemplate.update(INSERT_MEALS,
                    userId,meal.getLocalDateTime(),meal.getDescription(),
                    meal.getCalories());
            meal.setMealId(newKey.intValue());
        }
        else{
            int counter=jdbcTemplate.update(UPDATE_MEALS,meal.getLocalDateTime(),meal.getDescription(),meal.getCalories(),
                    userId,meal.getMealId());
            if(counter==0)throw new NotFoundException("Object for update not found!");
        }
        return meal;
    }

    @Override
    public boolean delete(int id, int userId) {
           int counter=jdbcTemplate.update(DELETE_MEALS,id,userId);
           return counter != 0;
    }

    @Override
    public UserMeal get(int userId, int mealId) {
        List<UserMeal>meals= jdbcTemplate.query(GET_MEAL,new MealMapper(),userId,mealId);
        return meals.isEmpty()?null: DataAccessUtils.requiredSingleResult(meals);
    }

    @Override
    public Collection<UserMeal> getAll(int userID) {
           return jdbcTemplate.query(GET_ALL,new MealMapper(),userID);
    }

    @Override
    public Collection<UserMeal> getBetween(LocalDateTime startDateTime, LocalDateTime endLocalDateTime, int userId) {
        return null;
    }
}
