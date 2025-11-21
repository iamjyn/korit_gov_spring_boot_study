package com.korit.korit_gov_spring_boot_study.controller;

import com.korit.korit_gov_spring_boot_study.dto.request.AddPostReqDto;
import com.korit.korit_gov_spring_boot_study.dto.response.AddPostRespDto;
import com.korit.korit_gov_spring_boot_study.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
* Inversion of Control => 제어의 역전
* 객체 생성과 제어의 주도권을 개발자가 아닌, 스프링부트가 갖는 것
* IoC Container => 스프링부트가 만든 객체들을 담아두고 관리하는 창고
* 필요한 곳이 있으면 꺼내서 넣어줌
* IoC Container에서 해당 객체를 찾아서 자동으로 넣어주니까 우리는 new하면서 객체 생성할 필요가 없음
* 이미 서버거 실행될 때 IoC Container에 객체들이 생성 후 보관되어 있음
*
* Dependency Injection => DI 의존성 주입
* 필요한 객체(의존성)를 직접 만들지 않고, 외부에서 대신 넣어주는 것
* */
@RestController
@RequestMapping("/post") // 공통 경로 추가
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/add")
    public ResponseEntity<AddPostRespDto> addPost(@RequestBody AddPostReqDto addPostReqDto) {
        return ResponseEntity.ok(postService.addPost(addPostReqDto));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getPostListAll() {
        return ResponseEntity.ok(postService.getPostListAll());
    }

    @GetMapping("/id")
    public ResponseEntity<?> getPostByPostId(@RequestParam Integer id) {
        return ResponseEntity.ok(postService.getPostByPostId(id));
    }

    @GetMapping("/keyword")
    public ResponseEntity<?> getPostByKeyword(@RequestParam String keyword) {
        return ResponseEntity.ok(postService.getPostByKeyword(keyword));
    }
}
