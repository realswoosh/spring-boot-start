package com.example.realdm99.chapter6.persistence;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.realdm99.chapter6.domain.WebBoard;

public interface WebBoardRepository
        extends CrudRepository<WebBoard, Long>, QuerydslPredicateExecutor<WebBoard> {
}
