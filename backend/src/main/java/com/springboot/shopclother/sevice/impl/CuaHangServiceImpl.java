package com.springboot.shopclother.sevice.impl;

import com.springboot.shopclother.entity.CuaHangEntity;
import com.springboot.shopclother.repository.CuaHangRepository;
import com.springboot.shopclother.sevice.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuaHangServiceImpl implements CuaHangService {
    @Autowired
    private CuaHangRepository cuaHangRepository;

    @Override
    public CuaHangEntity getCuaHangById(Integer id) {
        return cuaHangRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cửa hàng không tồn tại với id: " + id));
    }
}
