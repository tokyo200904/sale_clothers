package com.springboot.shopclother.sevice;

import com.springboot.shopclother.model.dto.UserdkDTO;

public interface UserdkSevice {
    UserdkDTO createUserdk(UserdkDTO userdkDTO) throws Exception;
    String login(String email, String password) throws Exception;

}
