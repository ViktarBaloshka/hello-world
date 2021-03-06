package com.helloworld.helloworld.service;

import java.util.List;
import java.util.Map;

public interface MessageService {
    List<Map<String, String>> list();

    Map<String, String> getOne(String id);

    Map<String, String> create(Map<String, String> message);

    Map<String, String> update(String id, Map<String, String> message);

    void delete(String id);

}
