package com.example.cup.demo.service;

import com.example.cup.demo.dao.DreamDaoMapper;
import com.example.cup.demo.pojo.Dream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DreamManager {

    @Autowired
    private DreamDaoMapper dreamDaoMapper;

    public void save(){
        Dream dream = new Dream("11","22",2);
        dream.setContent("hello");
        dream.setTime(String.valueOf(System.currentTimeMillis()));
        dreamDaoMapper.create(dream);
    }

    public Dream find(){
        return dreamDaoMapper.find(1);
    }
}
