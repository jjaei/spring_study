package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;
    //new로 객체를 생성해서 쓰면 MemberController 뿐만 아니라 다른 컨트롤러도 이 new 객체를 가져다 쓸 수 있다.
    // 하나만 생성해서 같이 공유해서 쓰기로 한다. (생성자, Autowired)
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
