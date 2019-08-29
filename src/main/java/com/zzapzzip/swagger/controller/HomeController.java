package com.zzapzzip.swagger.controller;

import com.zzapzzip.swagger.model.Member;
import com.zzapzzip.swagger.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class HomeController {

    MemberRepository memberRepository;

    @GetMapping("/members")
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @GetMapping("/member/{idx}")
    public Member findMember(@PathVariable Long idx) {
        return memberRepository.findById(idx).get();
    }

    @PostMapping("/member")
    public Member saveMember(@RequestBody Member member){
        return memberRepository.save(member);
    }

    @PutMapping("/member")
    public Member updateMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    @DeleteMapping("/member/{idx}")
    public String deleteMember(@PathVariable Long idx) {
        memberRepository.deleteById(idx);
        return "delete";
    }

}
