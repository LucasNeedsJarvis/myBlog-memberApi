package com.myblog.memberapi.adapter.out.persistence;

import com.myblog.memberapi.application.port.out.RegisterMemberPort;
import com.myblog.memberapi.domain.Member;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements RegisterMemberPort {

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
}
