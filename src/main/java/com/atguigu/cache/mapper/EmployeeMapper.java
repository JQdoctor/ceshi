package com.atguigu.cache.mapper;

import com.atguigu.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {
    @Select("SELECT * FROM employee WHERE id = #{id}")
    public Employee getEmployee(Integer id);

    @Update("UPDATE employee SET lastName=#{lastName},email=#{email},gender=#{gender},did=#{did} WHERE id=#{id}")
    public void updateEmployee(Employee employee);

    @Delete("DELECT FROM employee WHERE id=#{id}")
    public void delectEmployee(Integer id);

    @Insert("INSERT INTO employee(lastName,email,gender,did) VALUES(#{lastName},#{email},#{gender},#{did})")
    public void insertEmployee(Employee employee);
}
