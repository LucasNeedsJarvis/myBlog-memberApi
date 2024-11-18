package com.myblog.memberapi.adapter.in.web;

import com.myblog.memberapi.application.port.in.RegisterMemberCommand;
import com.myblog.memberapi.application.port.in.RegisterMemberUseCase;
import com.myblog.memberapi.domain.Member;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMemberController {

    private final RegisterMemberUseCase registerMemberUseCase;

    @PostMapping(path = "/member/register")
    Member registerMember(@RequestBody RegisterMemberRequest request) {
        RegisterMemberCommand command = RegisterMemberCommand.builder()
                .name(request.getName())
                .password(request.getPassword())
                .email(request.getEmail())
                .isValid(false)
                .build();
        return registerMemberUseCase.registerMember(command);
    }
}
