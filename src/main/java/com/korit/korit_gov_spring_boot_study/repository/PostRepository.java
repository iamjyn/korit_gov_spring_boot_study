package com.korit.korit_gov_spring_boot_study.repository;

import com.korit.korit_gov_spring_boot_study.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository // IoC
public class PostRepository {
    private List<Post> postList;

    private PostRepository() {
        postList = new ArrayList<>();
    }

    public Post findPostByTitle(String title) {
        return postList.stream()
                .filter(t -> t.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    public void addPost(Post post) {
        post.setPostId(postList.size() + 1);
        postList.add(post);
    }

    public List<Post> getPostListAll() {
        return postList;
    }

    public Post getPostByPostId(Integer id) {
        return postList.stream()
                .filter(i -> i.getPostId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Post> getPostByKeyword(String keyword) {
        return postList = postList.stream()
                .filter(k -> k.getTitle()
                .contains(keyword))
                .toList();
    }
}
