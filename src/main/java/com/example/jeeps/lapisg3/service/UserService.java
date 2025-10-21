package com.example.jeeps.lapisg3.service;

import com.example.jeeps.lapisg3.entity.UserEntity;
import com.example.jeeps.lapisg3.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    //Constructor injection 
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE
    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    // READ - all users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // READ - by ID
    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // UPDATE
    public Optional<UserEntity> updateUser(Long id, UserEntity updatedUser) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(updatedUser.getName());
                    existingUser.setEmail(updatedUser.getEmail());
                    existingUser.setPassword(updatedUser.getPassword());
                    return userRepository.save(existingUser);
                });
    }

    // DELETE
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
