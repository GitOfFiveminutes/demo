package com.example.cup.demo.rep;

import com.example.cup.demo.pojo.Dream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DreamHRepository extends JpaRepository<Dream,Integer> {
}
