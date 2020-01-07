package com.example.realdm99.chapter5.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberVO {

    private int mno;
    private String mid;
    private String mpw;
    private String mname;
    private Timestamp regdate;
}
