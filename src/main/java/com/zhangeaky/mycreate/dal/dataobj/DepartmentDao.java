package com.zhangeaky.mycreate.dal.dataobj;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DepartmentDao {

    List<Department> findAll();

    @Select("select * from tbl_department where name = #{name}")
    Department findById(String name);
}


