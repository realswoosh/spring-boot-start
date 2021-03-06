package com.example.realdm99.chapter5.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.realdm99.chapter5.domain.MemberVO;

@Controller
public class SampleController {
    @GetMapping("/sample1")
    public String sample1(Model model) {
        //model.addAttribute("greeting", "hello world");
        //model.addAttribute("greeting", "안녕하세요");
        return "sample1_new";
    }

    @GetMapping("/sample2")
    public void sample2(Model model) {
        MemberVO vo = new MemberVO(123, "u00", "p00", "홍길동",
                                   new Timestamp(System.currentTimeMillis()));
        model.addAttribute("vo", vo);
    }

    @GetMapping("/sample3")
    public void sample3(Model model) {
        List<MemberVO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(
                    new MemberVO(123,
                                 "u0" + i,
                                 "po" + i,
                                 "홍길동" + i, new Timestamp(System.currentTimeMillis())));
        }
        model.addAttribute("list", list);
    }

    @GetMapping("/sample4")
    public void sample4(Model model) {
        List<MemberVO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new MemberVO(
                    i, "u000" + i % 3,
                    "p000" + i % 3,
                    "홍길동" + i,
                    new Timestamp(System.currentTimeMillis())));
        }
        model.addAttribute("list", list);
    }

    @GetMapping("/sample5")
    public void sample5(Model model) {
        String result = "SUCCESS";
        model.addAttribute("result", result);
    }

    @GetMapping("/sample6")
    public void sample6(Model model) {
        List<MemberVO> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new MemberVO(i, "u0" + i, "p0" + i, "홍길동" + i,
                                  new Timestamp(System.currentTimeMillis())));
        }
        model.addAttribute("list", list);

        String result = "SUCCESS";
        model.addAttribute("result", result);
    }

    @GetMapping("/sample8")
    public void sample8() {
    }

    @GetMapping("/sample/hello")
    public void hello() {

    }
}
