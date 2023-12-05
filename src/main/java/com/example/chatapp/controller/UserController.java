package com.example.chatapp.controller;

import com.example.chatapp.model.User;
import com.example.chatapp.model.response.GetUsersResponse;
import com.example.chatapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/getUsers")
    public ResponseEntity<GetUsersResponse> getUsers(){
        return ResponseEntity.ok(userService.findAll());
    }
}
