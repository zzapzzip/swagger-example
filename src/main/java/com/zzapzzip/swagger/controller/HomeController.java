package com.zzapzzip.swagger.controller;

import com.zzapzzip.swagger.model.Member;
import com.zzapzzip.swagger.repository.MemberRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class HomeController {

    MemberRepository memberRepository;

    @ApiOperation("모든 Member List를 가져온다.")
    @GetMapping("/members")
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @ApiOperation("idx에 해당하는 Member를 가져온다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "idx", value = "회원 index", dataType = "integer", required = true)
    })
    @GetMapping("/member/{idx}")
    public Member findMember(@PathVariable Long idx) {
        return memberRepository.findById(idx).get();
    }

    @ApiOperation("Member를 저장한다.")
    @PostMapping("/member")
    public Member saveMember(@RequestBody Member member){
        return memberRepository.save(member);
    }

    @ApiOperation("Member를 수정한다.")
    @PutMapping("/member")
    public Member updateMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    @ApiOperation("Member를 제거한다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "idx", value = "회원 index", dataType = "integer", required = true)
    })
    @DeleteMapping("/member/{idx}")
    public String deleteMember(@PathVariable Long idx) {
        memberRepository.deleteById(idx);
        return "delete";
    }

}
