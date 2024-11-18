package com.myblog.memberapi.adapter.in.web;

import com.myblog.memberapi.application.port.in.RegisterMemberCommand;
import com.myblog.memberapi.application.port.in.RegisterMemberUseCase;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMemberController {

    private final RegisterMemberUseCase registerMemberUseCase;

    @PostMapping(path = "/member/register")
    ResponseEntity<String> registerMember(@RequestBody RegisterMemberRequest request) {
        RegisterMemberCommand command = RegisterMemberCommand.builder()
                .name(request.getName())
                .password(request.getPassword())
                .email(request.getEmail())
                .isValid(false)
                .build();

        try {
            registerMemberUseCase.registerMember(command);

            System.out.println("회원이 추가되었습니다.");
            System.out.println(command.toString());

            return ResponseEntity.ok("회원 등록 신청 완료.\n" + command.toString());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
