package com.example.cup.demo.dao;

import com.example.cup.demo.pojo.Dream;
import org.springframework.stereotype.Repository;

@Repository
public interface DreamDaoMapper {

    Integer create(Dream dream);

    Dream find(Integer id);
}
