package jpastudy.shop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)

public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Rollback(value = false)
    @Transactional
    public void test01(){
        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        Long save = memberRepository.save(member);
        Member findMember = memberRepository.find(save);

        //then
        assertThat(findMember.getId()).isEqualTo(member.getId());
        //저장한 객체와 조회한 객체가 같을까?
        //1차 캐쉬에서 관리되고 있는 객체를 비교하므로 동일한 객체..
        System.out.println("findMember = " + findMember);
        System.out.println("member = " + member);
        assertThat(findMember).isEqualTo(member);
    }


}