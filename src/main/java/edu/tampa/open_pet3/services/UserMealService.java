package edu.tampa.open_pet3.services;

import edu.tampa.open_pet3.model.User;
import edu.tampa.open_pet3.model.UserMeal;
import edu.tampa.open_pet3.util.exception.NotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public interface UserMealService {
    UserMeal save(int userId, UserMeal user);

    void delete(int id, int userId) throws NotFoundException;

    UserMeal get(int id, int userId) throws NotFoundException;

    List<UserMeal> index(int userId);

    default List<UserMeal>getBetweenDates(LocalDate startDate,LocalDate endDate,
                                          int userId){
        return getBetweenDateTimes(LocalDateTime.of(startDate, LocalTime.MIN),
                LocalDateTime.of(endDate,LocalTime.MAX),userId);
    }
    List<UserMeal> getBetweenDateTimes(LocalDateTime startDateTime,LocalDateTime endTime,int userid);
//    void evictCache();
}
