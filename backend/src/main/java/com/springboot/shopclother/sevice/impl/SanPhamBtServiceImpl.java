package com.springboot.shopclother.sevice.impl;

import com.springboot.shopclother.converter.SanPhamBtMapper;
import com.springboot.shopclother.entity.SanPhamBtEntity;
import com.springboot.shopclother.entity.SanPhamEntity;
import com.springboot.shopclother.model.dto.SanPhamBtDTO;
import com.springboot.shopclother.repository.SanPhamBtRepository;
import com.springboot.shopclother.repository.SanPhamRepository;
import com.springboot.shopclother.sevice.SanPhamBtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamBtServiceImpl implements SanPhamBtService {

    @Autowired
    private SanPhamBtRepository sanPhamBtRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private SanPhamBtMapper sanPhamBtMapper;

    @Override
    public SanPhamBtDTO getByIdSanPhamBt(Integer id) {
        SanPhamBtEntity entity = sanPhamBtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chi tiết sản phẩm"));
        return sanPhamBtMapper.toDTO(entity);
    }

    @Override
    public SanPhamBtDTO createSanPhamBt(Integer id,SanPhamBtDTO dto) {
        SanPhamEntity sp = sanPhamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sản phẩm không tồn tại"));

        SanPhamBtEntity entity = sanPhamBtMapper.toEntity(dto);
        entity.setSanPham(sp);

        SanPhamBtEntity saved = sanPhamBtRepository.save(entity);
        return sanPhamBtMapper.toDTO(saved);
    }

    @Override
    public SanPhamBtDTO updateSanPham(Integer id, SanPhamBtDTO dto) {
        SanPhamBtEntity entity = sanPhamBtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chi tiết sản phẩm"));

        entity.setChatLieuSanPham(dto.getChatLieuSanPham());
        entity.setKichCo(dto.getKichCo());
        entity.setMauSac(dto.getMauSac());
        entity.setSoLuongTrongKho(dto.getSoLuongTrongKho());
        entity.setGiaSanPham(dto.getGiaSanPham());
        entity.setAnh(dto.getAnh());

        SanPhamBtEntity saved = sanPhamBtRepository.save(entity);
        return sanPhamBtMapper.toDTO(saved);
    }

    @Override
    public void deleteSanPhamBt(Integer id) {
        sanPhamBtRepository.deleteById(id);
    }

    @Override
    public List<SanPhamBtDTO> getBySanPhamId(Integer maSP) {
        List<SanPhamBtEntity> list = sanPhamBtRepository.findBySanPham_MaSP(maSP);
        return sanPhamBtMapper.toDTOList(list);
    }
}
