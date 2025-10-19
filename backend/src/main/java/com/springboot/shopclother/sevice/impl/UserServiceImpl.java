package com.springboot.shopclother.sevice.impl;

import com.springboot.shopclother.converter.UserMapper;
import com.springboot.shopclother.entity.UserEntity;
import com.springboot.shopclother.model.dto.UserDTO;
import com.springboot.shopclother.repository.UserRepository;
import com.springboot.shopclother.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserDTO> getAllUsers() {
        return userMapper.toDTOList(userRepository.findAll());
    }

    @Override
    public UserDTO getUserById(Integer id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO createUser(UserDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email đã tồn tại");
        }
        UserEntity user = userMapper.toEntity(dto);
        user.setNgayTao(new Date());
        UserEntity saved = userRepository.save(user);
        return userMapper.toDTO(saved);
    }

    @Override
    public UserDTO updateUser(Integer id, UserDTO dto) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));
        user.setTenKhachHang(dto.getTenKhachHang());
        user.setEmail(dto.getEmail());
        user.setSoDienThoai(dto.getSoDienThoai());
        user.setDiaChi(dto.getDiaChi());
        user.setMatKhau(dto.getMatKhau());
        user.setRole(dto.getRole());
        UserEntity updated = userRepository.save(user);
        return userMapper.toDTO(updated);
    }

    @Override
    public void deleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy người dùng để xóa");
        }
        userRepository.deleteById(id);
    }
}