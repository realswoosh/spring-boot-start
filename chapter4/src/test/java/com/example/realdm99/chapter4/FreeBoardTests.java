package com.example.realdm99.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Commit;

import com.example.realdm99.chapter4.domain.FreeBoard;
import com.example.realdm99.chapter4.domain.FreeBoardReply;
import com.example.realdm99.chapter4.persistence.FreeBoardReplyRepository;
import com.example.realdm99.chapter4.persistence.FreeBoardRepository;

@SpringBootTest
@Commit
public class FreeBoardTests {
    @Autowired
    FreeBoardRepository freeBoardRepository;

    @Autowired
    FreeBoardReplyRepository freeBoardReplyRepository;

    @Test
    public void insertDummy() {
        IntStream.range(1, 200).forEach(i -> {
            FreeBoard board = new FreeBoard();
            board.setTitle("Free Board..." + i);
            board.setContent("Free Content..." + i);
            board.setWriter("user" + i % 10);
            freeBoardRepository.save(board);
        });
    }

    @Test
    @Transactional
    public void insertReply2Way() {
        Optional<FreeBoard> result = freeBoardRepository.findById(199L);
        result.ifPresent(board -> {
            List<FreeBoardReply> replies = board.getReplies();
            FreeBoardReply reply = new FreeBoardReply();
            reply.setReply("REPLY.....................");
            reply.setBoard(board);
            replies.add(reply);
            freeBoardRepository.save(board);
        });
    }

    @Test
    @Transactional
    public void testList1() {
        PageRequest page = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
        freeBoardRepository.findByBnoGreaterThan(0L, page).forEach(board -> {
            System.out.println(board.getBno() + ": " + board.getTitle() + ": " + board.getReplies().size());
        });
    }

    @Test
    public void testList3() {
        PageRequest page = PageRequest.of(0, 10, Direction.DESC, "bno");
        freeBoardRepository.getPage(page).forEach(arr -> {
            System.out.println(Arrays.toString(arr));
        });
    }
}
