package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    // 하나의 테스트는 의존관계 없이 설계되어야 함.
    @AfterEach
    public void afterEach() {  // 메서드 실행이 끝날 때마다 호출됨.
        memberRepository.clearStore();  // 테스트가 끝날때마다 저장소를 지움.
    }


    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("hello");

        // when 무엇을 검증할 것인가
        Long saveId = memberService.join(member);

        // then 검증
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    // 위의 테스트 코드는 너무 단순하다. 테스트는 예외 플로우가 중요하다.
    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//    try {
//        memberService.join(member1);
//        fail();
//       } catch(IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존하는 회원입니다.");
//       }
        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findeOne() {
    }
}