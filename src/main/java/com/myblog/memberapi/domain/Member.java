package com.myblog.memberapi.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {

    @Getter
    private final String memberId;

    @Getter
    private final String password;

    @Getter
    private final String name;

    @Getter
    private final String email;

    @Getter
    private final boolean isValid;

    public static Member generateMember(
            MemberId memberId,
            MemberName memberName,
            MemberPassword memberPassword,
            MemberEmail memberEmail,
            MemberIsValid memberIsValid) {
        return new Member(
                memberId.memberId,
                memberName.nameValue,
                memberPassword.passwordValue,
                memberEmail.emailValue,
                memberIsValid.isValidValue
        );
    }

    @Value
    public static class MemberId {
        public MemberId(String value) {
            this.memberId = value;
        }

        String memberId;
    }

    @Value
    public static class MemberName {
        public MemberName(String value) {
            this.nameValue = value;
        }

        String nameValue;
    }

    @Value
    public static class MemberEmail {
        public MemberEmail(String value) {
            this.emailValue = value;
        }

        String emailValue;
    }

    @Value
    public static class MemberPassword {
        public MemberPassword(String value) {
            this.passwordValue = value;
        }

        String passwordValue;
    }

    @Value
    public static class MemberIsValid {
        public MemberIsValid(boolean value) {
            this.isValidValue = value;
        }

        boolean isValidValue;
    }
}
