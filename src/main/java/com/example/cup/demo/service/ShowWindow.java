package com.example.cup.demo.service;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.swing.*;
import java.awt.*;

public class ShowWindow extends JPanel {
    public ShowWindow(){
        JLabel label = new JLabel(new ImageIcon("/png/logo1.png"));
        JButton aa = new JButton("aa");
        this.add(aa);
        this.add(label);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("window");
        window.setLayout(new GridLayout(1,2));
        window.setBackground(Color.BLUE);
        window.getContentPane().add(new ShowWindow());
        window.pack();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void mybatisBuild(){
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(new Configuration());
        SqlSession sqlSession = build.openSession();
        DreamManager mapper = sqlSession.getMapper(DreamManager.class);
        mapper.save();
    }
}
