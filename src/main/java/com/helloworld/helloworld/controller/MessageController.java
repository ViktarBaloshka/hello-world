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

    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id) {
        return messageService.getOne(id);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> message) {
        return messageService.create(message);
    }

    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> message) {
        return messageService.update(id, message);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
    }
}
