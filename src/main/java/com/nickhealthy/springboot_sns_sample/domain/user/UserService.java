package com.nickhealthy.springboot_sns_sample.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User signUp(String username, String password) {
        if (userRepository.existsByUsername(username)) {
            throw new UserException(UserException.ErrorCode.DUPLICATE_USERNAME);
        }

        User user = User.create(username,passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserException(UserException.ErrorCode.USER_NOT_FOUND));
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserException(UserException.ErrorCode.USER_NOT_FOUND));
    }

    @Transactional
    public void delete(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException(UserException.ErrorCode.USER_NOT_FOUND));
        user.delete();
    }
}
