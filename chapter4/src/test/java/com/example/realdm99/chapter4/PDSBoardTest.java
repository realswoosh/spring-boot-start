package com.example.realdm99.chapter4;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.realdm99.chapter4.domain.PDSBoard;
import com.example.realdm99.chapter4.domain.PDSFile;
import com.example.realdm99.chapter4.persistence.PDSBoardRepository;

@SpringBootTest
public class PDSBoardTest {
    @Autowired
    PDSBoardRepository repo;

    @Test
    public void testInsertPDS() {
        PDSBoard pds = new PDSBoard();
        pds.setPname("Document");

        PDSFile file1 = new PDSFile();
        file1.setPdsFile("file1.doc");

        PDSFile file2 = new PDSFile();
        file2.setPdsFile("file2.doc");

        PDSFile file3 = new PDSFile();
        file3.setPdsFile("file3.doc");

        pds.setFiles(Arrays.asList(file1, file2, file3));

        repo.save(pds);
    }
}
