package com.pohinian.springvue.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Created by Park Ji Hoon (pohinian@gmail.com) on 2018. 4. 16..
 */
@RestController
public class MemberResource {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members")
    public List<Member> retrieveAllMembers() {
        return memberRepository.findAll();
    }

    @GetMapping("/members/{id}")
    public Member retrieveMember(@PathVariable long id) {
        Optional<Member> member = memberRepository.findById(id);

        if (!member.isPresent()) throw new MemberNotFoundException("id-" + id);

        return member.get();
    }

    @DeleteMapping("/members/{id}")
    public void deleteMember(@PathVariable long id) {
        memberRepository.deleteById(id);
    }

    @PostMapping("/members")
    public ResponseEntity<Object> createMember(@RequestBody Member member) {
        Member saveMember = memberRepository.save(member);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveMember.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<Object> updateMember(@RequestBody Member member, @PathVariable long id) {
        Optional<Member> memberOptional = memberRepository.findById(id);

        if (!memberOptional.isPresent()) return ResponseEntity.notFound().build();

        member.setId(id);
        memberRepository.save(member);

        return ResponseEntity.noContent().build();

    }

}
