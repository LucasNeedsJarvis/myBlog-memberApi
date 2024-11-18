package com.myblog.memberapi.application.service;

import com.myblog.memberapi.adapter.out.persistence.MemberJpaEntity;
import com.myblog.memberapi.adapter.out.persistence.MemberMapper;
import com.myblog.memberapi.adapter.out.persistence.SpringDataMemberRepository;
import com.myblog.memberapi.application.port.in.UpdateMemberInfoUseCase;
import com.myblog.memberapi.application.port.in.UpdateMemberIsValidCommand;
import com.myblog.memberapi.application.port.out.UpdateMemberInfoPort;
import com.myblog.memberapi.domain.Member;
import common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
public class UpdateMemberInfoService implements UpdateMemberInfoUseCase {

    private final UpdateMemberInfoPort updateMemberInfoPort;
    private final SpringDataMemberRepository memberRepository;

    @Override
    public void updateMemberIsValid(UpdateMemberIsValidCommand command) {

        // 해당 ID 회원 조회
        MemberJpaEntity member = updateMemberInfoPort.findById(command.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다. ID: " + command.getMemberId()));

        System.out.println(">>>> " + command.toString());

        // isValid 값 변경
        member.setValid(command.isValid());

        System.out.println(">>>> " + member.toString());

        updateMemberInfoPort.save(member);
    }
}
