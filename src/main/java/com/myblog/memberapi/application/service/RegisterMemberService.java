package com.myblog.memberapi.application.service;

import com.myblog.memberapi.adapter.out.persistence.MemberJpaEntity;
import com.myblog.memberapi.adapter.out.persistence.MemberMapper;
import com.myblog.memberapi.adapter.out.persistence.SpringDataMemberRepository;
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
    private final SpringDataMemberRepository memberRepository;

    @Override
    public Member registerMember(RegisterMemberCommand command) {

        if (registerMemberPort.existsByEmail(command.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.[입력 email: " + command.getEmail() + "]");
        }

        MemberJpaEntity jpaEntity = registerMemberPort.createMember(
                new Member.MemberName(command.getName()),
                new Member.MemberPassword(command.getPassword()),
                new Member.MemberEmail(command.getEmail()),
                new Member.MemberIsValid(command.isValid())
        );

        return memberMapper.mapToDomainEntity(jpaEntity);
    }
}
