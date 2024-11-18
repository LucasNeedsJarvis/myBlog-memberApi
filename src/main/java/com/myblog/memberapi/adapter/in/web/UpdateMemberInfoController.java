package com.myblog.memberapi.adapter.in.web;

import com.myblog.memberapi.application.port.in.UpdateMemberInfoUseCase;
import com.myblog.memberapi.application.port.in.UpdateMemberIsValidCommand;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class UpdateMemberInfoController {

    private final UpdateMemberInfoUseCase updateMemberInfoUseCase;

    @PostMapping(path = "/member/update/isValid")
    ResponseEntity<String> updateMemberIsValid(@RequestBody UpdateMemberIsValidRequest request) {

        UpdateMemberIsValidCommand command = UpdateMemberIsValidCommand.builder()
                .memberId(request.getMemberId())
                .isValid(request.isValid())
                .build();

        try {
            updateMemberInfoUseCase.updateMemberIsValid(command);

            if (command.isValid()) {
                System.out.println("회원 정보 변경 완료.\nID:" + command.getMemberId() + " : VALID");
                return ResponseEntity.ok("회원 정보 변경 완료.\nID:" + command.getMemberId() + " : VALID");
            } else {
                System.out.println("회원 정보 변경 완료.\nID:" + command.getMemberId() + " : INVALID");
                return ResponseEntity.ok("회원 정보 변경 완료.\nID:" + command.getMemberId() + " : INVALID");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
