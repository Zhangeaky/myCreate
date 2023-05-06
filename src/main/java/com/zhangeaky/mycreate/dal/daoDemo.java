package com.zhangeaky.mycreate.dal;

import com.zhangeaky.mycreate.dal.dataobj.Department;
import com.zhangeaky.mycreate.dal.dataobj.DepartmentDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.io.InputStream;
import java.sql.*;
import java.util.List;

public class daoDemo {

    public static void testJDBC() throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;
        Statement statement = null;
        // 使用DriverManager 连接数据库这种方式已经很老了
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhangeaky", "root", "a1234567");

        System.in.read();

    }

    public static void testJDBCTemplate() {

        String path = "classpath:/META-INF/spring/data-integration.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(path);
        context.refresh();
        JdbcTemplate template = context.getBean(JdbcTemplate.class);
        template.execute("insert into T values(23,23,'tongshao');");

        template.execute("insert into T values(#{A},#{B},#{C});", new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

                return null;
            }
        });
    }


    public static void test_mybatis() throws Exception{

        InputStream xml = Resources.getResourceAsStream("database/sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
        List<Department> all = mapper.findAll();
        Department 开发部 = mapper.findById("开发部");
        System.out.println(开发部);
        all.forEach(System.out::println);
        //List<Department> departmentList = sqlSession.selectList("departmentMapper.findAll");
        //departmentList.forEach(System.out::println);

    }

    public static void main(String[] args) throws Exception{

        //testJDBCTemplate();
        test_mybatis();


    }
}
