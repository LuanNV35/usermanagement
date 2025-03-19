package com.example.usermanagement.service;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Đăng ký người dùng mới
    public User registerUser(User user) {
        // Kiểm tra username/email đã tồn tại hay chưa có thể được thêm tại đây
        // Mã hóa mật khẩu nếu cần (sử dụng BCryptPasswordEncoder nếu tích hợp Spring Security)
        return userRepository.save(user);
    }

    // Lấy thông tin người dùng theo id
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Người dùng không tồn tại"));
    }

    // Cập nhật thông tin người dùng
    public User updateUser(Long id, User updatedUser) {
        User user = getUserById(id);
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        // Nếu cập nhật mật khẩu thì cần mã hóa trước khi lưu
        return userRepository.save(user);
    }
}

