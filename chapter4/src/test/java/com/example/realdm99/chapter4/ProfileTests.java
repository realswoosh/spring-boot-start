package com.example.realdm99.chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.example.realdm99.chapter4.domain.Member;
import com.example.realdm99.chapter4.domain.Profile;
import com.example.realdm99.chapter4.persistence.MemberRerpository;
import com.example.realdm99.chapter4.persistence.ProfileRepository;

@SpringBootTest
@Commit
public class ProfileTests {
    @Autowired
    MemberRerpository memberRerpository;

    @Autowired
    ProfileRepository profileRepository;

    @Test
    public void testInsertMembers() {
        IntStream.range(1, 101).forEach(i -> {
            Member member = new Member();
            member.setUid("user" + i);
            member.setUpw("pw" + i);
            member.setName("사용자" + i);
            memberRerpository.save(member);
        });
    }

    @Test
    public void testInsertProfile() {
        Member member = new Member();
        member.setUid("user1");

        for (int i = 1; i < 5; i++) {
            Profile profile1 = new Profile();
            profile1.setFname("face" + i + ".jpg");
            if (i == 1) {
                profile1.setCurrent(true);
            }
            profile1.setMember(member);
            profileRepository.save(profile1);
        }
    }

    @Test
    public void testFetchJoin1() {
        List<Object[]> result = memberRerpository.getMemberWithProfileCount("user1");
        result.forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    @Test
    public void testFetchJoin2() {
        List<Object[]> result = memberRerpository.getMemberWithProfile("user1");
        result.forEach(arr -> System.out.println(Arrays.toString(arr)));
    }
}