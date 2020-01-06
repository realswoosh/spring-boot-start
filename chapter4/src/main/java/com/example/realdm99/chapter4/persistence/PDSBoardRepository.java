package com.example.realdm99.chapter4.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.realdm99.chapter4.domain.PDSBoard;

public interface PDSBoardRepository extends CrudRepository<PDSBoard, Long> {
}
