package com.korit.korit_gov_spring_boot_study.service;

import com.korit.korit_gov_spring_boot_study.dto.request.AddPostReqDto;
import com.korit.korit_gov_spring_boot_study.dto.response.AddPostRespDto;
import com.korit.korit_gov_spring_boot_study.dto.response.GetPostRespDto;
import com.korit.korit_gov_spring_boot_study.entity.Post;
import com.korit.korit_gov_spring_boot_study.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // IoC
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // 추가(title 중복확인)
    public AddPostRespDto addPost(AddPostReqDto addPostReqDto) {
        if (postRepository.findPostByTitle(addPostReqDto.getTitle()) != null) {
            return AddPostRespDto.builder()
                    .status("failed")
                    .message("이미 사용중인 title 입니다.")
                    .build();
        }
        postRepository.addPost(addPostReqDto.toEntity());
        return AddPostRespDto.builder()
                .status("success")
                .message("post 등록 완료")
                .build();
    }

    // 전체 조회
    public GetPostRespDto<?> getPostListAll() {
        return GetPostRespDto.<List<Post>>builder()
                .status("success")
                .message("전체 조회 완료")
                .body(postRepository.getPostListAll())
                .build();
    }

    // postId 단건 조회
    public GetPostRespDto<?> getPostByPostId(Integer id) {
        if (postRepository.getPostByPostId(id) == null) {
            return GetPostRespDto.builder()
                    .status("failed")
                    .message("해당 id는 존재하지 않습니다.")
                    .build();
        }
        return GetPostRespDto.<Post>builder()
                .status("success")
                .message("전체 조회 완료")
                .body(postRepository.getPostByPostId(id))
                .build();
    }

    // 키워드(타이틀) 조회
    public GetPostRespDto<?> getPostByKeyword(String keyword) {
        if (postRepository.getPostByKeyword(keyword) == null) {
            return GetPostRespDto.builder()
                    .status("failed")
                    .message("해당 title은 존재하지 않습니다.")
                    .build();
        }
        return GetPostRespDto.<List<Post>>builder()
                .status("success")
                .message("조회 완료")
                .body(postRepository.getPostByKeyword(keyword))
                .build();
    }
}
