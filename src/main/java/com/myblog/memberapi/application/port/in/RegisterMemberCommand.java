package com.myblog.memberapi.application.port.in;

import common.SelfValidating;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterMemberCommand extends SelfValidating<RegisterMemberCommand> {

    @NotNull
    private final String name;

    @NotNull
    private final String password;

    @NotNull
    private final String email;

    @AssertFalse
    private final boolean isValid;

    public RegisterMemberCommand(String name, String password, String email, boolean isValid) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.isValid = isValid;
    }
}
