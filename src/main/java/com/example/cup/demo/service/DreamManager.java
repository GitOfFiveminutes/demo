package com.example.cup.demo.service;

import com.example.cup.demo.dao.DreamDaoMapper;
import com.example.cup.demo.dao.DreamHRepository;
import com.example.cup.demo.pojo.Dream;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DreamManager {

    @Autowired
    private DreamDaoMapper dreamDaoMapper;
    @Autowired
    private DreamHRepository dreamHRepository;

    public void save(){
        Dream dream = new Dream("","",Integer.valueOf(RandomStringUtils.randomNumeric(10)));
        dream.setContent(RandomStringUtils.randomAlphabetic(20));
        dream.setTime(String.valueOf(System.currentTimeMillis()));
        dreamDaoMapper.create(dream);
    }

    public void saveByH(){
        Dream dream = new Dream("","",Integer.valueOf(RandomStringUtils.randomNumeric(5)));
        dream.setContent(RandomStringUtils.randomAlphabetic(20));
        dream.setTime(String.valueOf(System.currentTimeMillis()));
        dreamHRepository.save(dream);
    }
    public Dream find(){
        return dreamDaoMapper.find(1);
    }
}
