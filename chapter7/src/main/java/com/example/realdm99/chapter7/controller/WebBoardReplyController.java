package com.example.realdm99.chapter7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.realdm99.chapter7.domain.WebReply;
import com.example.realdm99.chapter7.persistence.WebReplyRepository;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/replies/*")
public class WebBoardReplyController {
    @Autowired
    private WebReplyRepository webReplyRepository;


    @PostMapping("/{bno}")
    public ResponseEntity<Void> addReply(@PathVariable("bno") Long bno, @RequestBody WebReply reply) {
        log.info("addReply........................");
        log.info("bno: " + bno);
        log.info("REPLY: " + reply);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
