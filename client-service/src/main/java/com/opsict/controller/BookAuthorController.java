package com.opsict.controller;

import com.google.protobuf.Descriptors;
import com.opsict.service.BookAuthorCilentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class BookAuthorController {
    private final BookAuthorCilentService bookAuthorCilentService;

    @GetMapping("/author/{id}")
    public Map<Descriptors.FieldDescriptor, Object> getAuthor(@PathVariable String id) {
        return bookAuthorCilentService.getAuthor(Integer.parseInt(id));
    }

    @GetMapping("/book/{id}")
    public List<Map<Descriptors.FieldDescriptor, Object>> getBooksByAuthorId(@PathVariable String id) {
        return bookAuthorCilentService.getBooksByAuthorId(Integer.parseInt(id));
    }

    @GetMapping("/book")
    public Map<String, Map<Descriptors.FieldDescriptor, Object>> getExpensiveBook() {
        try {
            return bookAuthorCilentService.getExpensiveBook();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }

    @GetMapping("/book/author/{gender}")
    public List<Map<Descriptors.FieldDescriptor, Object>> getBooksByAuthorGender(@PathVariable String gender) {
        try {
            return bookAuthorCilentService.getBooksByAuthorGender(gender);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


}
