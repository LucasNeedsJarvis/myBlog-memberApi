package com.myblog.memberapi.adapter.in.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMemberIsValidRequest {

    private Long memberId;
    
    @JsonProperty("isValid")
    private boolean isValid;
}
