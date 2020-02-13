package com.example.realdm99.chapter7;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.example.realdm99.chapter7.domain.WebBoard;
import com.example.realdm99.chapter7.domain.WebReply;
import com.example.realdm99.chapter7.persistence.WebReplyRepository;

import groovy.util.logging.Log;

@SpringBootTest
@Log
@Commit
public class WebReplyRepositoryTests {
    @Autowired
    WebReplyRepository repo;

    @Test
    public void testInsertReplies() {
        Long[] arr = {304L, 303L, 300L};

        Arrays.stream(arr).forEach(num -> {
            WebBoard board = new WebBoard();
            board.setBno(num);

            IntStream.range(0, 10).forEach(i -> {
                WebReply reply = new WebReply();
                reply.setReplyText("REPLY ...:" + i);
                reply.setReplyer("replyer" + i);
                reply.setBoard(board);
                repo.save(reply);
            });
        });
    }
}
