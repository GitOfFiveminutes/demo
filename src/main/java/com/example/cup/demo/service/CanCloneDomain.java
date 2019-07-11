package com.example.cup.demo.service;

public class CanCloneDomain implements Cloneable{

    CanCloneDomain(){}

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
