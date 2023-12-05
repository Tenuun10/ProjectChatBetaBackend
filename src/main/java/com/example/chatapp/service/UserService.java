package com.example.chatapp.service;

import com.example.chatapp.model.response.GetUsersResponse;
import com.example.chatapp.model.response.UserResponse;
import com.example.chatapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public GetUsersResponse findAll(){
       var users = userRepository.findAll().stream()
               .map(user -> modelMapper.map(user,UserResponse.class))
               .collect(Collectors.toList());
       return GetUsersResponse.builder().users(users).build();
    }
}
