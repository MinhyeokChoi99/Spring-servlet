package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("kim",28);

        //when
        memberRepository.save(member);
        //then
        Assertions.assertThat(memberRepository.findById(member.getId())).isEqualTo(member);
    }

    @Test
    void findAll() {

        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);
        //when
        memberRepository.save(member1);
        memberRepository.save(member2);
        //then
        List<Member> result = memberRepository.findAll();
        Assertions.assertThat(result.size()).isSameAs(2);
        Assertions.assertThat(result).contains(member1, member2);


    }
}
