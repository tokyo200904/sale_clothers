package com.springboot.shopclother.sevice;

import com.springboot.shopclother.model.dto.SanPhamBtDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SanPhamBtService {
    SanPhamBtDTO getByIdSanPhamBt(Integer id);
    SanPhamBtDTO createSanPhamBt(Integer id,SanPhamBtDTO dto);
    SanPhamBtDTO updateSanPham(Integer id,SanPhamBtDTO dto);
    void deleteSanPhamBt(Integer id);
    List<SanPhamBtDTO> getBySanPhamId(Integer maSP);

}
