package com.myblog.memberapi.application.port.out;

import com.myblog.memberapi.adapter.out.persistence.MemberJpaEntity;

import java.util.Optional;

public interface UpdateMemberInfoPort {

    Optional<MemberJpaEntity> findById(Long memberId);

    void save(MemberJpaEntity member);
}
