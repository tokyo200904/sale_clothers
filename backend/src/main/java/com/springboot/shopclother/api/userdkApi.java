package com.springboot.shopclother.api;

import com.springboot.shopclother.entity.UserEntity;
import com.springboot.shopclother.model.dto.UserLoginDTO;
import com.springboot.shopclother.model.dto.UserdkDTO;
import com.springboot.shopclother.sevice.UserdkSevice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/users")
@CrossOrigin(origins = "*")
public class userdkApi {
    @Autowired
    private UserdkSevice userdkSevice;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserdkDTO userdkDTO,
                                        BindingResult result){
        try {
            if (result.hasErrors()){
                List<String> errors = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errors);
            }
            UserdkDTO newUser = userdkSevice.createUserdk(userdkDTO);

            return ResponseEntity.ok(newUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserLoginDTO userLoginDTO){
        try {
            String token = userdkSevice.login(userLoginDTO.getEmail(), userLoginDTO.getMatKhau());
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
