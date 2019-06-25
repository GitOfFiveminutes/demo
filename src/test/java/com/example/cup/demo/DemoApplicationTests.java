package com.example.cup.demo;

import com.example.cup.demo.dao.DreamDaoMapper;
import com.example.cup.demo.pojo.Dream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private DreamDaoMapper daoMapper;

    @Test
    public void contextLoads() {

        daoMapper.create(new Dream("222","111",1));
    }

}
