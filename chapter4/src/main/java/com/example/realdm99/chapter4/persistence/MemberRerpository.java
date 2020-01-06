package com.example.realdm99.chapter4.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.realdm99.chapter4.domain.Member;

public interface MemberRerpository extends CrudRepository<Member, String> {

    @Query("SELECT m.uid, count(p) from Member m LEFT OUTER JOIN Profile p " +
           " ON m.uid = p.member WHERE m.uid = ?1 GROUP BY m")
    public List<Object[]> getMemberWithProfileCount(String uid);

    @Query("SELECT m, p from Member m LEFT OUTER JOIN Profile p " +
           " ON m.uid = p.member WHERE m.uid = ?1 and p.current = true")
    public List<Object[]> getMemberWithProfile(String uid);
}
