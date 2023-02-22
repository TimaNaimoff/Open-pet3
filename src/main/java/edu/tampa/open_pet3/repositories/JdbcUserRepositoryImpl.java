package edu.tampa.open_pet3.repositories;

import edu.tampa.open_pet3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcUserRepositoryImpl implements UserRepository{
    private static final BeanPropertyRowMapper<User>ROW_MAPPER=BeanPropertyRowMapper.newInstance(User.class);
    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate parameterJdbcTemplate;

    private SimpleJdbcInsert insertUser;

    @Autowired
    public JdbcUserRepositoryImpl(JdbcTemplate jdbcTemplate,NamedParameterJdbcTemplate parameterJdbcTemplate){
        this.insertUser=new SimpleJdbcInsert(jdbcTemplate).withTableName("users")
                .usingGeneratedKeyColumns("id");
        this.jdbcTemplate=jdbcTemplate;
        this.parameterJdbcTemplate=parameterJdbcTemplate;
    }
    @Override
    public User save(User user) {
        MapSqlParameterSource map= new MapSqlParameterSource().
                addValue("id",user.getId()).
                addValue("name",user.getName()).
                addValue("email",user.getEmail()).
                addValue("password",user.getPassword()).
                addValue("registered",user.getRegistered()).
                addValue("enabled",user.isEnabled());
        if(user.isNew()){
            Number newKey=insertUser.executeAndReturnKey(map);
            user.setId(newKey.intValue());
        }
        else{
            parameterJdbcTemplate.update("UPDATE users SET name=:name." +
                    "email=:email,password=:password,registered=:registered,enabled=:enabled",map);
        }
        return user;
    }


    @Override
    public boolean delete(int id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id = ?",id)!=0;
    }

    @Override
    public User get(int id) {
        User user=jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?",ROW_MAPPER,id);
        return user;
    }
    public List<User> gett(int id) {
        List<User>users=jdbcTemplate.query("SELECT * FROM users WHERE id = ?",ROW_MAPPER,id);
        return users;
    }

    @Override
    public User getByMail(String email) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM users ORDER BY name,email",ROW_MAPPER);
    }
}
