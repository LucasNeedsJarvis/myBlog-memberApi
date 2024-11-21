package com.myblog.memberapi.application.port.in;

import com.myblog.memberapi.domain.Member;

public interface FindMemberUseCase {
    Member findMember(FindMemberCommand command);
}
