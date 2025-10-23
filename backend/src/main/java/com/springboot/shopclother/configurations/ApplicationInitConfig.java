package com.springboot.shopclother.configurations;

import com.springboot.shopclother.entity.UserEntity;
import com.springboot.shopclother.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class ApplicationInitConfig {
    @Autowired
    PasswordEncoder passwordEncoder;
    // tao tai khoan admin neu chua co trong db
    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository) {
        return args -> {
            Optional<UserEntity> adminOpt = userRepository.findByRole("ADMIN");
            if (adminOpt.isEmpty()) {
                UserEntity admin = new UserEntity();
                admin.setTenKhachHang("phuc");
                admin.setEmail("phuc@gmail.com");
                admin.setMatKhau(passwordEncoder.encode("123456"));
                admin.setSoDienThoai("0123456789");
                admin.setDiaChi("Rau ma city");
                admin.setRole("ADMIN");
                admin.setEnable(true);
                admin.setNgayTao(new Date());

                userRepository.save(admin);
            }
        };
    }
}
