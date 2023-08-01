package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given, 이런 게 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when, 이렇게 하면
        memberService.join(member);
        Member findMember = memberService.findById(1L);

        // then, 이렇게 된다.
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
