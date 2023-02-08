package com.zhangeaky.mycreate.controller.login;

import com.alibaba.druid.support.json.JSONUtils;
import com.zhangeaky.mycreate.bean.User;
import com.zhangeaky.mycreate.dal.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    JdbcTemplate template;

    @Autowired
    UserRepository userRepository;

    Connection connection;

    @PostConstruct
    void init() {
        try {
            this.connection = Optional.of(template.getDataSource())
                    .get().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String query = "select * from user where name = ?";

    @RequestMapping("/query")
    String query(@RequestParam String name) {
        System.out.println("%%%%%%%%%%%%5");
        User user = userRepository.queryForUser(name);
        return user.toString();
    }

    public String test() {

        template.execute(new ConnectionCallback<User>() {

            @Override
            public User doInConnection(Connection con) throws SQLException, DataAccessException {
                return null;
            }
        });

        return "";
    }


    /**
     *
     * @param user
     * @return
     */
    @RequestMapping("/add")
    //@Transactional
    boolean addUser(@RequestBody User user, boolean ifBreak) {
        return userRepository.addUser(user, ifBreak);
    }

    @RequestMapping("/queryForAll")
    List<User> queryAll() {

        return userRepository.queryAllUsers();

    }
}
