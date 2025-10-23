package com.springboot.shopclother.configurations;

import com.springboot.shopclother.entity.UserEntity;
import com.springboot.shopclother.filters.JwtTokenFliter;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@RequiredArgsConstructor
public class WebSecurityConfig {

    @Autowired
    private JwtTokenFliter jwtTokenFliter;

    @Value("${api.prefix}")
    private String apiPrefix;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtTokenFliter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(requests -> {
                    requests
                            .requestMatchers(
                                    String.format("%s/users/login",apiPrefix),
                                    String.format("%s/users/register",apiPrefix)
                            )
                            .permitAll()
                            .requestMatchers(GET,String.format("%s/admin/danhmuc/**",apiPrefix)).hasAnyRole("ADMIN")
                            .requestMatchers(PUT,String.format("%s/admin/danhmuc/**",apiPrefix)).hasAnyRole("ADMIN")
                            .requestMatchers(POST,String.format("%s/admin/danhmuc/**",apiPrefix)).hasAnyRole("ADMIN")
                            .requestMatchers(DELETE,String.format("%s/admin/danhmuc/**",apiPrefix)).hasAnyRole("ADMIN")

                            .requestMatchers(GET,String.format("%s/admin/sanpham/**",apiPrefix)).hasAnyRole("ADMIN")
                            .requestMatchers(PUT,String.format("%s/admin/sanpham/**",apiPrefix)).hasAnyRole("ADMIN")
                            .requestMatchers(POST,String.format("%s/admin/sanpham/**",apiPrefix)).hasAnyRole("ADMIN")
                            .requestMatchers(DELETE,String.format("%s/admin/sanpham/**",apiPrefix)).hasAnyRole("ADMIN")

                            .requestMatchers(GET,String.format("%s/admin/sanphambt/**",apiPrefix)).hasAnyRole("ADMIN")
                            .requestMatchers(PUT,String.format("%s/admin/sanphambt/**",apiPrefix)).hasAnyRole("ADMIN")
                            .requestMatchers(POST,String.format("%s/admin/sanphambt/**",apiPrefix)).hasAnyRole("ADMIN")
                            .requestMatchers(DELETE,String.format("%s/admin/sanphambt/**",apiPrefix)).hasAnyRole("ADMIN")

                            .requestMatchers(GET,String.format("%s/admin/users/**",apiPrefix)).hasAnyRole("ADMIN")
                            .requestMatchers(PUT,String.format("%s/admin/users/**",apiPrefix)).hasAnyRole("ADMIN","CUSTOMER")
                            .requestMatchers(DELETE,String.format("%s/admin/users/**",apiPrefix)).hasAnyRole("ADMIN")

                            .anyRequest().authenticated();

                });
        return http.build();
    }
}
