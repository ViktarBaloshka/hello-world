package com.helloworld.helloworld.service.impl;
import com.helloworld.helloworld.exceptions.NotFoundException;
import com.helloworld.helloworld.service.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {
    private int counter = 1;
    private List<Map<String, String>> messages = new ArrayList<>() {
    };

    @Override
    public List<Map<String, String>> list() {
        return messages;
    }
    private Map<String, String> getMessage(String id) {
        return messages.stream()
                .filter(messages -> messages.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id) {
        return getMessage(id);
    }

    @PostMapping("{id}")
    public Map<String, String> create(@RequestBody Map<String, String> message) {
        message.put("id", String.valueOf(counter++));
        messages.add(message);
        return message;
    }

    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> message) {
        Map<String, String> messageFromDb = getMessage(id);
        messageFromDb.putAll(message);
        message.put("id", id);
        return messageFromDb;
    }

    @DeleteMapping("{id}")
    /*Почему когда было public void delete(@PathVariable String id) не сработало, хотя по идее
    * удаление записи ничего не должно возвращать. Когжа написал как есть и вернул message, то сработало?  */
    public Map<String, String> delete(@PathVariable String id) {
        Map<String, String> message = getMessage(id);
        messages.remove(message);
        return message;
    }
}
