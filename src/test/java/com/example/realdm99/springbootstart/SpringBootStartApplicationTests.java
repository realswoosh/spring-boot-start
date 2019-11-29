package com.example.realdm99.springbootstart;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.realdm99.springbootstart.entity.Board;
import com.example.realdm99.springbootstart.repository.BoardRepository;

@SpringBootTest
class SpringBootStartApplicationTests {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testInsert() {
        Board board = new Board();
        board.setTitle("게시물의 제목");
        board.setContent("게시물 내용 넣기....");
        board.setWriter("user00");
        boardRepository.save(board);
    }

    @Test
    public void testRead() {
        boardRepository.findById(1L).ifPresent((board) -> {
            System.out.println(board);
        });
    }

    @Test
    public void testUpdate() {
        System.out.println("Read First.................");
        Board board = boardRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("Update Title ..............");
        board.setTitle("수정된 제목");
        System.out.println("Call Save()................");
        boardRepository.save(board);
    }

    @Test
    public void testDelete() {
        System.out.println("DELETE Entity ");
        Board board = new Board();
        board.setBno(1L);
        boardRepository.delete(board);
    }
}
