package com.myblog.memberapi.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterMemberRequest {

    private String name;
    private String password;
    private String email;
}
