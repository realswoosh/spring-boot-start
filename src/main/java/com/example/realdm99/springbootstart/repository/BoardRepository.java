package com.example.realdm99.springbootstart.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.realdm99.springbootstart.entity.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
}
