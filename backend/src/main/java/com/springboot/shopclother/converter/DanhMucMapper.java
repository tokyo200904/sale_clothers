package com.springboot.shopclother.converter;


import com.springboot.shopclother.entity.DanhMucConEntity;
import com.springboot.shopclother.entity.DanhMucEntity;
import com.springboot.shopclother.model.dto.DanhMucConDTO;
import com.springboot.shopclother.model.dto.DanhMucDTO;

import java.util.List;
import java.util.stream.Collectors;
public class DanhMucMapper {

    public static DanhMucDTO toDTO(DanhMucEntity entity) {
        DanhMucDTO dto = new DanhMucDTO();
        dto.setMaDanhMuc(entity.getMaDanhMuc());
        dto.setTenDanhMuc(entity.getTenDanhMuc());

        if (entity.getDanhMucCons() != null) {
            List<DanhMucConDTO> list = entity.getDanhMucCons().stream()
                    .map(DanhMucMapper::toDanhMucConDTO)
                    .collect(Collectors.toList());
            dto.setDanhMucConList(list);
        }

        return dto;
    }

    public static DanhMucConDTO toDanhMucConDTO(DanhMucConEntity entity) {
        DanhMucConDTO dto = new DanhMucConDTO();
        dto.setMaDMC(entity.getMaDMC());
        dto.setTenDMC(entity.getTenDMC());

        if (entity.getDanhMuc() != null) {
            dto.setMaDanhMuc(entity.getDanhMuc().getMaDanhMuc());
            dto.setTenDanhMuc(entity.getDanhMuc().getTenDanhMuc());
        }

        return dto;
    }
}