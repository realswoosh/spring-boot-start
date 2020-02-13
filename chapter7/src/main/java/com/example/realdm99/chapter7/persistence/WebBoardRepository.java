package com.example.realdm99.chapter6.persistence;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.realdm99.chapter6.domain.QWebBoard;
import com.example.realdm99.chapter6.domain.WebBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public interface WebBoardRepository
        extends CrudRepository<WebBoard, Long>, QuerydslPredicateExecutor<WebBoard> {

    default Predicate makePredicate(String type, String keyword) {
        BooleanBuilder builder = new BooleanBuilder();
        QWebBoard qBoard = QWebBoard.webBoard;
        builder.and(qBoard.bno.gt(0));

        if (type == null) {
            return builder;
        }

        switch (type) {
            case "t":
                builder.and(qBoard.title.like("%" + keyword + "%"));
                break;
            case "c":
                builder.and(qBoard.content.like("%" + keyword + "%"));
                break;
            case "w":
                builder.and(qBoard.writer.like("%" + keyword + "%"));
                break;
        }
        return builder;
    }
}
