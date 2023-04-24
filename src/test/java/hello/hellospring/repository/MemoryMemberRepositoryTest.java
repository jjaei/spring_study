package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 하나의 테스트는 의존관계 없이 설계되어야 함.
    @AfterEach
    public void afterEach() {  // 메서드 실행이 끝날 때마다 호출됨.
        repository.clearStore();  // 테스트가 끝날때마다 저장소를 지움.
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //    System.out.println("result = " + (result == member));
        //    Assertions.assertEquals(member, result);  다른 값이라면 빨간 불이 뜸.
        Assertions.assertThat(member).isEqualTo(result);
    }

        @Test
        public  void findByName() {
           Member member1 = new Member();
           member1.setName("spring1");
           repository.save(member1);

           Member member2 = new Member();
           member2.setName("spring2");
           repository.save(member2);

          Member result = repository.findByName("spring2").get();
          Assertions.assertThat(result).isEqualTo(member2);
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

        Assertions.assertThat(result.size()).isEqualTo(2);

        }
    }

