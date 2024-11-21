package com.myblog.memberapi.application.service;


import com.myblog.memberapi.adapter.out.persistence.MemberJpaEntity;
import com.myblog.memberapi.adapter.out.persistence.MemberMapper;
import com.myblog.memberapi.application.port.in.FindMemberCommand;
import com.myblog.memberapi.application.port.in.FindMemberUseCase;
import com.myblog.memberapi.application.port.out.FindMemberPort;
import com.myblog.memberapi.domain.Member;
import common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
@Transactional
public class FindMemberService implements FindMemberUseCase {

    private final FindMemberPort findMemberPort;
    private final MemberMapper memberMapper;

    @Override
    public Member findMember(FindMemberCommand command) {
        MemberJpaEntity member = findMemberPort.findById(new Member.MemberId(command.getMemberId())).orElseThrow(() -> new IllegalArgumentException("Member with ID " + command.getMemberId() + " not found"));

        return memberMapper.mapToDomainEntity(member);
    }
}
