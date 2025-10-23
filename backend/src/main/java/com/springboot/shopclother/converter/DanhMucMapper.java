package com.springboot.shopclother.converter;


import com.springboot.shopclother.entity.DanhMucEntity;
import com.springboot.shopclother.model.dto.DanhMucDTO;

public class DanhMucMapper {

    public static DanhMucDTO toDTO(DanhMucEntity entity) {
        DanhMucDTO dto = new DanhMucDTO();
        dto.setMaDanhMuc(entity.getMaDanhMuc());
        dto.setTenDanhMuc(entity.getTenDanhMuc());
        return dto;
    }

}