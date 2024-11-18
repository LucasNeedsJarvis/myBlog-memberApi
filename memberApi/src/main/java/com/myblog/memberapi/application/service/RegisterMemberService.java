package com.myblog.memberapi.application.service;

import com.myblog.memberapi.adapter.out.persistence.MemberJpaEntity;
import com.myblog.memberapi.adapter.out.persistence.MemberMapper;
import com.myblog.memberapi.application.port.in.RegisterMemberCommand;
import com.myblog.memberapi.application.port.in.RegisterMemberUseCase;
import com.myblog.memberapi.application.port.out.RegisterMemberPort;
import com.myblog.memberapi.domain.Member;
import common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterMemberService implements RegisterMemberUseCase {

    private final RegisterMemberPort registerMemberPort;
    private final MemberMapper memberMapper;

    @Override
    public Member registerMember(RegisterMemberCommand command) {
        MemberJpaEntity jpaEntity = registerMemberPort.createMember(
                new Member.MemberName(command.getName()),
                new Member.MemberPassword(command.getPassword()),
                new Member.MemberEmail(command.getEmail()),
                new Member.MemberIsValid(command.isValid())
        );

        System.out.println("회원이 추가되었습니다.");
        System.out.println(jpaEntity.toString());

        return memberMapper.mapToDomainEntity(jpaEntity);
    }
}
