package com.example.realdm99.chapter7;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Commit;

import com.example.realdm99.chapter7.EnumTest;
import com.example.realdm99.chapter7.EnumTest.PriceTaxClassify;
import com.example.realdm99.chapter7.domain.WebBoard;
import com.example.realdm99.chapter7.persistence.WebBoardRepository;

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

    @Test
    public void testList1() {
        PageRequest pageable = PageRequest.of(0, 20, Direction.DESC, "bno");

        Page<WebBoard> result = webBoardRepository.findAll(webBoardRepository.makePredicate(null, null),
                                                           pageable);

        System.out.println("PAGE: " + result.getPageable());
        System.out.println("-------------------");

        result.getContent().forEach(board -> System.out.println("" + board));
    }

    @Test
    public void testList2() {
        PageRequest pageRequest = PageRequest.of(0, 20, Direction.DESC, "bno");

        Page<WebBoard> result = webBoardRepository.findAll(
                webBoardRepository.makePredicate("t", "10"), pageRequest);

        System.out.println("PAGE: " + result.getPageable());

        System.out.println("------------------------");
        result.getContent().forEach(board -> System.out.println("" + board));
    }

    @Test
    public void testEnum() {
        EnumTest enumTest = new EnumTest();
        enumTest.setPriceTaxClassify(PriceTaxClassify.TAX_EXCLUDE);

        System.out.println(enumTest.getPriceTaxClassify());
    }
}
