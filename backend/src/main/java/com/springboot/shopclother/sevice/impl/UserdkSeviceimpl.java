package com.springboot.shopclother.sevice.impl;

import com.springboot.shopclother.configurations.jwtTokenUtil;
import com.springboot.shopclother.entity.UserEntity;
import com.springboot.shopclother.model.dto.UserDTO;
import com.springboot.shopclother.model.dto.UserdkDTO;
import com.springboot.shopclother.repository.UserdkRepository;
import com.springboot.shopclother.sevice.UserdkSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserdkSeviceimpl implements UserdkSevice {
    @Autowired
    private UserdkRepository userdkRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private jwtTokenUtil jwrTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserdkDTO createUserdk(UserdkDTO userdkDTO) throws Exception {
        if (userdkRepository.existsByEmail(userdkDTO.getEmail())){
            throw new Exception("Email da ton tai");
        }
        if(userdkDTO.getMatKhauXacNhan() != null && !userdkDTO.getMatKhau().equals(userdkDTO.getMatKhauXacNhan())){
            throw new Exception("Mat khau xac nhan khong dung");
        }
        UserEntity user = new UserEntity();
        user.setTenKhachHang("nguoi dung moi");
        user.setSoDienThoai(null);
        user.setDiaChi("");
        user.setRole("customer");
        user.setEmail(userdkDTO.getEmail());
        user.setEnable(true);
        user.setNgayTao(new Date());

        String password = userdkDTO.getMatKhau();
        String encodedPassword = passwordEncoder.encode(password);
        user.setMatKhau(encodedPassword);
        UserEntity savedUser = userdkRepository.save(user);

        UserDTO result = new UserDTO();
        result.setTenKhachHang(savedUser.getTenKhachHang());
        result.setDiaChi(savedUser.getDiaChi());
        result.setSoDienThoai(savedUser.getSoDienThoai());
        result.setEmail(savedUser.getEmail());
        result.setRole(savedUser.getRole());
        result.setNgayTao(savedUser.getNgayTao());
        result.setEnabled(savedUser.getEnable());
        return userdkDTO;
    }

    @Override
    public String login(String email, String password) throws Exception {
        Optional<UserEntity> userOpt = userdkRepository.findByEmail(email);
        if (userOpt.isEmpty()){
            throw new Exception("Khong tim thay tai khoan");
    }
        UserEntity user = userOpt.get();
        if (!passwordEncoder.matches(password, user.getMatKhau())){
            throw new Exception("Mat khau khong dung");
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                email,password,
                user.getAuthorities()
        );
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        return jwrTokenUtil.generateToken(user);
    }


}
