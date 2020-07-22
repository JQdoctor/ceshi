package com.atguigu.cache;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringbootApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;  //操作字符串

    @Autowired
    RedisTemplate redisTemplate;  // 操作KV

    @Autowired
    RedisTemplate<Object, Employee> myRedisTemplate;

    /**
     * Redis常见五大数据类型
     * String、List、Set、Hash、Zset
     */
    @Test
    public  void  test01(){
        stringRedisTemplate.opsForValue().append("msg2","hello");
    }

    @Test
    public  void  test02(){
        String msg2 = stringRedisTemplate.opsForValue().get("msg2");
        System.out.println(msg2);
    }

    @Test
    public  void  test03(){
        Employee emp = employeeMapper.getEmployee(1);
        myRedisTemplate.opsForValue().set("emp-02",emp);
    }

    @Test
    void contextLoads() {
        Employee employee = employeeMapper.getEmployee(1);
        System.out.println(employee);
    }

}
