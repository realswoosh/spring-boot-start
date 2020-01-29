package com.example.realdm99.chapter6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.querydsl.QSort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.realdm99.chapter6.domain.WebBoard;
import com.example.realdm99.chapter6.persistence.WebBoardRepository;
import com.example.realdm99.chapter6.vo.PageMaker;
import com.example.realdm99.chapter6.vo.PageVO;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/boards/")
@Log
public class WebBoardController {

//    @GetMapping("/list")
//    public void list(@PageableDefault(direction = Direction.DESC,
//    sort = "bno",
//    size = 10,
//    page = 0) Pageable page) {
//        log.info("list() called..." + page);
//    }

    @Autowired
    private WebBoardRepository webBoardRepository;

    @GetMapping("/list")
    public void list(PageVO vo, Model model) {
        final Pageable page = vo.makePageable(0, "bno");

        final Page<WebBoard> result = webBoardRepository.findAll(webBoardRepository.makePredicate(null, null), page);

        log.info("" + page);
        log.info("" + result);

        model.addAttribute("result", new PageMaker(result));
    }
}
