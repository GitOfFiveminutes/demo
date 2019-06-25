package com.example.cup.demo.service;

import com.example.cup.demo.pojo.Dream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@RequestMapping("call")
public class DreamProvider {

    @Autowired
    private DreamManager dreamManager;

//    @GetMapping("/dream")
//    @ResponseBody
    @RequestMapping("/dream")
    @ResponseBody
    public String createDream(){
        dreamManager.save();
        return "success dream";
    }

    @RequestMapping("/find")
    public Dream findDream(){
        return dreamManager.find();
    }
}
