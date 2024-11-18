package com.myblog.memberapi.application.port.in;

import com.myblog.memberapi.domain.Member;

public interface RegisterMemberUseCase {

    Member registerMember(RegisterMemberCommand command);
}
