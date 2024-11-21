package com.myblog.memberapi.adapter.out.persistence;

import com.myblog.memberapi.application.port.out.FindMemberPort;
import com.myblog.memberapi.application.port.out.RegisterMemberPort;
import com.myblog.memberapi.application.port.out.UpdateMemberInfoPort;
import com.myblog.memberapi.domain.Member;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements RegisterMemberPort, UpdateMemberInfoPort, FindMemberPort {

    private final SpringDataMemberRepository memberRepository;

    @Override
    public MemberJpaEntity createMember(Member.MemberName memberName, Member.MemberPassword memberPassword, Member.MemberEmail memberEmail, Member.MemberIsValid memberIsValid) {

        return memberRepository.save(
                new MemberJpaEntity(
                        memberName.getNameValue(),
                        memberPassword.getPasswordValue(),
                        memberEmail.getEmailValue(),
                        memberIsValid.isValidValue()
                )
        );
    }

    @Override
    public boolean existsByEmail(String email) {
        return memberRepository.existsByEmail(email);
    }

    @Override
    public Optional<MemberJpaEntity> findById(Long memberId) {
        return memberRepository.findById(memberId);
    }

    @Override
    public void save(MemberJpaEntity member) {
        memberRepository.save(member);
    }

    @Override
    public Optional<MemberJpaEntity> findById(Member.MemberId memberId) {
        return memberRepository.findById(Long.valueOf(memberId.getMemberId()));
    }
}
