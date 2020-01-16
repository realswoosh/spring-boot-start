package com.example.realdm99.chapter6;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.example.realdm99.chapter6.domain.WebBoard;
import com.example.realdm99.chapter6.persistence.WebBoardRepository;

@SpringBootTest
@Commit
public class WebBoardRepositoryTests {
    @Autowired
    WebBoardRepository webBoardRepository;

    @Test
    public void insertBoardDummies() {
        IntStream.range(0, 300).forEach(i -> {
            WebBoard board = new WebBoard();

            board.setTitle("Sample Board Title " + i);
            board.setContent("Content Sample ..." + i + " of Board");
            board.setWriter("user0" + (i % 10));

            webBoardRepository.save(board);
        });
    }
}
