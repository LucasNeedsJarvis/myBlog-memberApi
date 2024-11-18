package com.myblog.memberapi.application.port.out;

import com.myblog.memberapi.adapter.out.persistence.MemberJpaEntity;
import com.myblog.memberapi.domain.Member;

public interface RegisterMemberPort {

    MemberJpaEntity createMember(
            Member.MemberName memberName
            , Member.MemberPassword memberPassword
            , Member.MemberEmail memberEmail
            , Member.MemberIsValid memberIsValid);
}
