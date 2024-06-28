//package umc.spring.controller;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import umc.spring.Service.MemberService;
//import umc.spring.entity.Member;
//
//import java.util.List;
//import java.util.Optional;
//
//@Slf4j
//@RestController
//@RequestMapping("/api/members")
//public class MemberController {
//    @Autowired
//    private MemberService memberService;
//
//    @PostMapping("/post")
//    public Member createMember(@RequestBody Member member) {
//        log.info("아이디:"+member.getId());
//        log.info("이름:"+member.getName());
//        log.info("이메일:"+member.getEmail());
//        log.info("비밀 번호:"+member.getPassword());
//
//        return memberService.saveMember(member);
//    }
//
//    @GetMapping
//    public List<Member> getAllMembers() {
//        return memberService.getAllMembers();
//    }
//
//    @GetMapping("/{id}")
//    public Optional<Member> getMemberById(@PathVariable Long id) {
//        return memberService.getMemberById(id);
//    }
//
//    @PutMapping("/{id}")
//    public Member updateMember(@PathVariable Long id, @RequestBody Member memberDetails) {
//        return memberService.updateMember(id, memberDetails);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteMember(@PathVariable Long id) {
//        memberService.deleteMember(id);
//    }
//}
