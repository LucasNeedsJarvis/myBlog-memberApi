package com.myblog.memberapi.application.port.in;

import common.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateMemberIsValidCommand extends SelfValidating<UpdateMemberIsValidCommand> {

    @NotNull
    private final Long memberId;

    @NotNull
    private final boolean isValid;

    public UpdateMemberIsValidCommand(Long memberId, boolean isValid) {
        this.memberId = memberId;
        this.isValid = isValid;
    }
}
