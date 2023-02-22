package edu.tampa.open_pet3.util.mappers;

import edu.tampa.open_pet3.model.UserMeal;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MealMapper implements RowMapper<UserMeal> {

    @Override
    public UserMeal mapRow(ResultSet resultSet, int i) throws SQLException {
        UserMeal meal=new UserMeal();
        meal.setMealId(resultSet.getInt("meal_id"));
//        meal.setLocalDateTime(resultSet.getTimestamp("local_date_time").toLocalDateTime());
        meal.setDescription(resultSet.getString("description"));
        meal.setCalories(resultSet.getInt("calories"));
        return meal;
    }
}
