package com.springboot.shopclother.sevice;



import com.springboot.shopclother.entity.SanPhamEntity;
import com.springboot.shopclother.model.dto.SanPhamDTO;

import java.util.List;

public interface SanPhamService {
    List<SanPhamDTO> getAllSanPham();
    SanPhamDTO createSanPham(SanPhamDTO dto);
    SanPhamDTO updateSanPham(Integer id, SanPhamDTO dto);
    void deleteSanPham(Integer id);
}