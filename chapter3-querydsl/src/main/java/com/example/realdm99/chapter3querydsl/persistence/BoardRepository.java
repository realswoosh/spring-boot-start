package com.example.realdm99.chapter3querydsl.persistence;

import com.example.realdm99.chapter3querydsl.domain.Board;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long>,
        QuerydslPredicateExecutor<Board> {

}
