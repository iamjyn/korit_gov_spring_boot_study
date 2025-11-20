package com.korit.korit_gov_spring_boot_study.service;

import com.korit.korit_gov_spring_boot_study.dto.request.SigninReqDto;
import com.korit.korit_gov_spring_boot_study.dto.request.SignupReqDto;
import com.korit.korit_gov_spring_boot_study.dto.response.SigninRespDto;
import com.korit.korit_gov_spring_boot_study.dto.response.SignupRespDto;
import com.korit.korit_gov_spring_boot_study.entity.User;
import com.korit.korit_gov_spring_boot_study.repository.UserRepository;

public class UserService {
    private static UserService instance;
    private UserRepository userRepository;

    private UserService() {
        userRepository = UserRepository.getInstance();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public SignupRespDto signup(SignupReqDto signupReqDto) {
        // 중복검사
        if (userRepository.findUserByUsername(signupReqDto.getUsername()) != null) {
            return new SignupRespDto("failed", "이미 사용중인 username입니다.");
        }
        // 회원가입 처리
        userRepository.addUser(signupReqDto.toEntity());
        // 이거에 따라서 응답 dto 다르게 반환
        return new SignupRespDto("success", "회원가입이 완료되었습니다.");
    }

    public SigninRespDto signin(SigninReqDto signinReqDto) {
        // 로그인
        // 해당 username으로 된 데이터를 들고옴 -> reqDto에 있는 password랑 들고온 password랑 비교
        User foundUser = userRepository.findUserByUsername(signinReqDto.getUsername());
        if (foundUser == null) {
            return new SigninRespDto("failed", "username이 일치하지 않습니다.");
        }
        if (!foundUser.getPassword().equals(signinReqDto.getPassword())) {
            return new SigninRespDto("failed", "password가 일치하지 않습니다.");
        }
        return new SigninRespDto("success", "성공적으로 로그인이 되었습니다.");
    }

}
