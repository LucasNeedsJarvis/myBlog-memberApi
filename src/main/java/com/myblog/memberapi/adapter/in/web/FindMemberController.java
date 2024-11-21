package com.myblog.memberapi.adapter.in.web;

import com.myblog.memberapi.application.port.in.FindMemberCommand;
import com.myblog.memberapi.application.port.in.FindMemberUseCase;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMemberController {

    private final FindMemberUseCase findMemberUseCase;

    @GetMapping(path = "/member/{memberId}")
    ResponseEntity<?> findMemberByMemberId(@PathVariable String memberId) {

        FindMemberCommand command = FindMemberCommand.builder()
                .memberId(memberId)
                .build();

        try {
            return ResponseEntity.ok(findMemberUseCase.findMember(command));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}