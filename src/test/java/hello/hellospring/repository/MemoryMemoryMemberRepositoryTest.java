package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 하나의 테스트는 의존관계 없이 설계되어야 함.
    @AfterEach
    public void afterEach() {  // 메서드 실행이 끝날 때마다 호출됨.
        repository.clearStore();  // 테스트가 끝날때마다 저장소를 지움.
    }

    @Test // save 기능이 동작하는지 확인하려면 애너테이션 test를 붙이면 됨.
    public void save() {
        Member member = new Member();
        member.setName("spring");  // 이름을 spring으로 세팅
        repository.save(member);

        Member result = repository.findById(member.getId()).get();  // 옵셔널에서 값을 꺼낼 때 get 사용
        //    System.out.println("result = " + (result == member));  단순 확인 ver
        assertThat(member).isEqualTo(result);  // 요즘은 assertThat을 많이 사용함.
        // member와 result와 같은지 확인. 다른 값이라면 빨간 불이 뜸.

    }

        @Test
        public  void findByName() {
           Member member1 = new Member();
           member1.setName("spring1");
           repository.save(member1);  // member1 저장

           Member member2 = new Member();
           member2.setName("spring2");
           repository.save(member2);  // 정교한 테스트를 위해 member2 저장

          Member result = repository.findByName("spring1").get();
          assertThat(result).isEqualTo(member1);
        }

        @Test
        public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

        }
    }