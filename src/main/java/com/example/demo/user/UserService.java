package com.example.demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public void join(UserRequest.JoinDTO joinDTO) {
        userRepository.save(joinDTO.toEntity());
    }

    public void login(UserRequest.LoginDTO loginDTO) {
        userRepository.findByUsername(loginDTO.getUsername());
    }
}
