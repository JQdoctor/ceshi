package com.atguigu.cache.service;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 缓存测试
     * @param id
     * @return
     */
    @Cacheable(cacheNames = {"emp"},keyGenerator = "myKeyGenerator")
    public Employee getEmp(Integer id){
        System.out.println("查询第"+id+"号员工");
        Employee employee = employeeMapper.getEmployee(id);
        return  employee;
    }

    @CachePut(value = "emp",key ="#result.id")
    public Employee  updateEmp(Employee employee){
        System.out.println("用户传输信息："+employee);
        employeeMapper.updateEmployee(employee);
        return employee;
    }



}
