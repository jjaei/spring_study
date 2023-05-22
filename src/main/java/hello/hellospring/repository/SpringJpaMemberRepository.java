package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{  // 인터페이스가 인터페이스를 받을 땐 extends 사용
    @Override
    Optional<Member> findByName(String name);
}
