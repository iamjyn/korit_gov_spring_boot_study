package com.korit.korit_gov_spring_boot_study.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SigninReqDto {
    private String username;
    private String password;
}
