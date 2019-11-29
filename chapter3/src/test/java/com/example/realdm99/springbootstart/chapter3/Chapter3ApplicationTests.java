package com.example.realdm99.springbootstart.chapter3;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.example.realdm99.springbootstart.chapter3.domain.Board;
import com.example.realdm99.springbootstart.chapter3.persistence.BoardRepository;

import jdk.nashorn.internal.ir.annotations.Ignore;

@SpringBootTest
class Chapter3ApplicationTests {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void contextLoads() {
    }

    @Ignore
    public void testInsert200() {
        for (int i = 1; i <= 200; i++) {
            Board board = new Board();
            board.setTitle("제목..." + i);
            board.setContent("내용 ...." + i + " 채우기 ");
            board.setWriter("user0" + (i % 10));
            boardRepository.save(board);
        }
    }

    @Test
    public void testByTitle() {
        boardRepository.findBoardByTitle("제목...177").forEach(System.out::println);
    }

    @Test
    public void testByWriter() {
        Collection<Board> results = boardRepository.findByWriter("user00");
        results.forEach(
                board -> System.out.println(board)
        );
    }

    @Test
    public void testByWriterContaining() {
        Collection<Board> results = boardRepository.findByWriterContaining("05");
        results.forEach(board -> System.out.println(board));
    }

    @Test
    public void testByTitleAndBno() {
        Collection<Board> results = boardRepository.findByTitleContainingAndBnoGreaterThan("5", 50L);
        results.forEach(board -> System.out.println(board));
    }

    @Test
    public void testBnoOrderBy() {
        Collection<Board> results =
                boardRepository.findByBnoGreaterThanOrderByBnoDesc(90L);
        results.forEach(board -> System.out.println(board));
    }

    @Test
    public void testBnoOrderByPaging() {
        // spring boot 2.0.0
        Pageable paging = PageRequest.of(0, 10);
        Collection<Board> results = boardRepository.findByBnoGreaterThanOrderByBnoDesc(0L, paging);
        results.forEach(board -> System.out.println(board));
    }

    @Test
    public void testBnoPagingSort() {
        Pageable paging = PageRequest.of(0, 10, Direction.ASC, "bno");
        Page<Board> results = boardRepository.findByBnoGreaterThan(0L, paging);

        System.out.println("PAGE SIZE: " + results.getSize());
        System.out.println("TOTAL PAGES: " + results.getTotalPages());
        System.out.println("TOTAL COUNT: " + results.getTotalElements());
        System.out.println("NEXT: " + results.nextPageable());

        results.getContent().forEach(board -> System.out.println(board));
    }
}
