package com.example.realdm99.chapter4.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.realdm99.chapter4.domain.FreeBoard;

public interface FreeBoardRepository extends CrudRepository<FreeBoard, Long> {

    public List<FreeBoard> findByBnoGreaterThan(Long bno, Pageable page);

    @Query("SELECT b.bno, b.title, count(r) "
           + " FROM FreeBoard b LEFT OUTER JOIn b.replies r group by b")
    public List<Object[]> getPage(Pageable page);
}
