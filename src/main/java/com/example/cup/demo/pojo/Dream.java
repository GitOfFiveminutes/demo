package com.example.cup.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class Dream {

    private String time;

    private String content;

    @Id
    private int id;

    Dream(){}
}
