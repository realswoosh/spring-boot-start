package com.example.realdm99.chapter3querydsl;

import com.example.realdm99.chapter3querydsl.persistence.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Chapter3QuerydslApplicationTests {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testPredicate() {

    }
}
