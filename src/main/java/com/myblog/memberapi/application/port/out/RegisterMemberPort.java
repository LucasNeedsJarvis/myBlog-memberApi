package com.myblog.memberapi.application.port.out;

import com.myblog.memberapi.adapter.out.persistence.MemberJpaEntity;
import com.myblog.memberapi.domain.Member;
import jakarta.validation.constraints.NotNull;

public interface RegisterMemberPort {

    MemberJpaEntity createMember(
            Member.MemberName memberName
            , Member.MemberPassword memberPassword
            , Member.MemberEmail memberEmail
            , Member.MemberIsValid memberIsValid);

    boolean existsByEmail(String email);
}
