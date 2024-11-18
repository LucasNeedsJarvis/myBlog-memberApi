package com.myblog.memberapi.adapter.out.persistence;

import com.myblog.memberapi.domain.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public Member mapToDomainEntity(MemberJpaEntity memberJpaEntity) {
        return Member.generateMember(
                new Member.MemberId(memberJpaEntity.getMemberId() + ""),
                new Member.MemberName(memberJpaEntity.getName()),
                new Member.MemberPassword(memberJpaEntity.getPassword()),
                new Member.MemberEmail(memberJpaEntity.getEmail()),
                new Member.MemberIsValid(memberJpaEntity.isValid())
        );
    }
}
