package com.springboot.shopclother.sevice;


import com.springboot.shopclother.model.dto.UserDTO;
import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Integer id);
    UserDTO createUser(UserDTO dto);
    UserDTO updateUser(Integer id, UserDTO dto);
    void deleteUser(Integer id);
}