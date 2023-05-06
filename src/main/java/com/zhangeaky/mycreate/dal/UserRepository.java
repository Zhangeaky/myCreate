package com.zhangeaky.mycreate.dal;

import com.zhangeaky.mycreate.annotations.ZhangEaky;
import com.zhangeaky.mycreate.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcAccessor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User queryForUser(String name) {
        return jdbcTemplate.queryForObject("select id, name, age, email from user where name = ?",
                (resultSet, index) -> {
                    System.out.println("index: " + index);
                    User user = new User();
                    user.setAge(Integer.valueOf(resultSet.getString("age")));
                    user.setEmail(resultSet.getString("email"));
                    user.setName(resultSet.getString("name"));
                    user.setId(Long.valueOf(resultSet.getString("id")));
                    return user;
                }, name);


    }

    public boolean addUser(User user, boolean ifBreak) {

        try {

            Connection connection = jdbcTemplate.getDataSource().getConnection();
            connection.setAutoCommit(false);


            jdbcTemplate.update("insert into user (id, name, age, email) values(?, ?, ?, ?)",
                    user.getId(), user.getName(), user.getAge(), user.getEmail());

            if (ifBreak) {
                connection.rollback();
                return false;
            }

            jdbcTemplate.update("insert into lesson values(8888)");
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }







        return true;
    }

    public List<User> queryAllUsers() {

        List<Map<String, Object>> results = jdbcTemplate.queryForList("select name, id, age, email from user");

        return results.stream().map(map->{
            User user = new User();
            user.setId((Long)map.get("id"));
            user.setName((String)map.get("name"));
            user.setEmail((String)map.get("email"));
            user.setAge((Integer)map.get("age"));
            return user;
        }).collect(Collectors.toList());
    }


}
