package com.korit.korit_gov_spring_boot_study.controller;

import com.korit.korit_gov_spring_boot_study.dto.request.SigninReqDto;
import com.korit.korit_gov_spring_boot_study.dto.request.SignupReqDto;
import com.korit.korit_gov_spring_boot_study.dto.response.SigninRespDto;
import com.korit.korit_gov_spring_boot_study.dto.response.SignupRespDto;
import com.korit.korit_gov_spring_boot_study.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    private UserService userService;

    public AuthController() {
        userService = UserService.getInstance();
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupRespDto> signup(@RequestBody SignupReqDto signupReqDto) {
        return ResponseEntity.ok(userService.signup(signupReqDto));
    }

    @PostMapping("/signin")
    public ResponseEntity<SigninRespDto> signin(@RequestBody SigninReqDto signinReqDto) {
        return ResponseEntity.ok(userService.signin(signinReqDto));
    }

    /*
    * 파라미터가 없으면 400에러
    * 타입이 안 맞을 때
    * 이름이 불일치
    *
    * 민감한 정보는 쓰지 않도록
    * */

//    @GetMapping("/get")
//    public String getUser(@RequestParam String userId) {
//        System.out.println("쿼리 파라미터로 들어온 값: " + userId);
//        return "쿼리 파라미터로 들어온 값: " + userId;
//    }
//
//    @GetMapping("/get/name")
//    public String getUsername(@RequestParam(value = "name", defaultValue = "홍길동") String username, @RequestParam(required = false) Integer age) {
//        return username + age;
//    }

    /*
    * value = "" 을 통해 파라미터의 키 이름을 다르게 설정 가능
    * defaultValue = "" 를 통해 값을 넣지 않았을 때 기본값을 설정 가능
    * required = false 를 통해 입력값이 필수가 아니게 설정 가능
    * 단, 필수가 아닐 때 자료형이 wrapper class 자료형이어야 한다.(null이 들어와야하기 때문에)
    * */

//    @PostMapping("/signup")
//    public String signup(@RequestBody SignupReqDto signupReqDto) {
//        System.out.println(signupReqDto);
//        return signupReqDto.getUsername() + "님 회원가입이 완료되었습니다.";
//    }

    /*
    * @RequestBody
    * HTTP 요청의 바디에 들어있는 JSON 데이터를 자바 객체(DTO)로 변환해서 주입해주는 어노테이션
    * 클라이언트가 JSON 형식으로 데이터를 보내면 서버에서 JSON을 파싱해 알아서 DTO에 대해서 매핑 후 주입
    * 단, JSON 데이터의 키와 객체의 멤버변수의 이름과 일치시켜야 한다.
    * */

//    @PostMapping("/signin")
//    public String signin(@RequestBody SigninReqDto signinReqDto) {
//        return "로그인 성공: " + signinReqDto.getUsername() + "님, 반갑습니다.";
//    }

    // get: @RequestParam
    // post: @RequestBody

    /*
    * ResponseEntity
    * HTTP 응답 전체를 커스터마이징을 해서 응답할 수 있는 스프링 클래스
    * 상태코드, 응답body, 응답header 등등
    * 200
    * 400
    * 401 => 인증실패
    * 403 => 접근권한 없음
    * 404
    * 500
    * */

//    @PostMapping("/signup")
//    public ResponseEntity<SignupRespDto> signup(@RequestBody SignupReqDto signupReqDto) {
//        if (signupReqDto.getUsername() == null || signupReqDto.getUsername().trim().isEmpty()) {
//            SignupRespDto signupRespDto = new SignupRespDto("failed", "username을 입력하세요.");
//            return ResponseEntity.badRequest().body(signupRespDto); // badRequest: 400 / ok: 200
//        } else if (signupReqDto.getPassword() == null || signupReqDto.getPassword().trim().isEmpty()) {
//            SignupRespDto signupRespDto = new SignupRespDto("failed", "비밀번호를 입력하세요.");
//            return ResponseEntity.badRequest().body(signupRespDto);
//
//        }
//        SignupRespDto signupRespDto = new SignupRespDto("success", "회원가입 성공");
//        return ResponseEntity.ok(signupRespDto); // ok는 ".body" 생략가능
//    }

    // 실제 컨트롤러처럼


}
