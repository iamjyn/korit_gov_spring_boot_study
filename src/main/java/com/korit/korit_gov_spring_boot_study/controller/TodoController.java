package com.korit.korit_gov_spring_boot_study.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
class TodoDto {
    private int todoId;
    private String title;
    private String content;
}

@Controller
public class TodoController {
    private List<TodoDto> todos = new ArrayList<>();

    // 추가, 결과, 목록 (html 3, api 3) / 타이틀, 콘텐츠
    @GetMapping("/todo")
    public String todo() {
        return "todo";
    }

    @PostMapping("/todo")
    public String todoSubmit(@RequestParam String title, @RequestParam String content, Model model) {
        TodoDto todoDto = new TodoDto(todos.size() + 1, title, content);
        todos.add(todoDto);
        model.addAttribute("message", title + " [todo 등록 완료]");
        return "result-todo";
    }

    @GetMapping("/todos")
    public String todoList(Model model) {
        model.addAttribute("todos", todos);
        return "todos";
    }
}
