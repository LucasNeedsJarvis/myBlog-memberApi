package com.myblog.memberapi.application.port.out;

import com.myblog.memberapi.adapter.out.persistence.MemberJpaEntity;
import com.myblog.memberapi.domain.Member;

import java.util.Optional;

public interface FindMemberPort {
    Optional<MemberJpaEntity> findById(Member.MemberId memberId);
}
