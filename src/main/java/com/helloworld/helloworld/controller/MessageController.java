package com.helloworld.helloworld.controller;

import com.helloworld.helloworld.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping
    public List<Map<String, String>> list() {
        return messageService.list();
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> message) {
        return messageService;
    }
}
