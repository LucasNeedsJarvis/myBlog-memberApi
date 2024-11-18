package com.myblog.memberapi.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "member")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String name;

    private String password;

    private String email;

    private boolean isValid;

    public MemberJpaEntity(String name, String password, String email, boolean isValid) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", isValid=" + isValid +
                '}';
    }

}
