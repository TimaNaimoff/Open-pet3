package edu.tampa.open_pet3.repositories.datajpa;


import edu.tampa.open_pet3.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProxyUserRepository extends JpaRepository<User,Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=?1")
    int delete(int i);
    @Override
    User save(User user);
    @Override
    User getOne(Integer id);
    @Override
    List<User> findAll(Sort sort);

    User getByEmail(String email);
}
