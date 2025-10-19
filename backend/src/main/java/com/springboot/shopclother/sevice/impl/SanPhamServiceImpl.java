package com.springboot.shopclother.sevice.impl;


import com.springboot.shopclother.converter.SanPhamMapper;
import com.springboot.shopclother.entity.DanhMucConEntity;
import com.springboot.shopclother.entity.SanPhamEntity;


import com.springboot.shopclother.model.dto.SanPhamDTO;
import com.springboot.shopclother.repository.DanhMucConRepository;
import com.springboot.shopclother.repository.SanPhamRepository;
import com.springboot.shopclother.sevice.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private DanhMucConRepository danhMucConRepository;

    @Autowired
    private SanPhamMapper sanPhamMapper;


    @Override
    public List<SanPhamDTO> getAllSanPham() {
        return sanPhamMapper.toDTOList(sanPhamRepository.findAll());    }

    @Override
    public SanPhamDTO createSanPham(SanPhamDTO dto) {
        SanPhamEntity entity = sanPhamMapper.toEntity(dto);

        DanhMucConEntity dmc = danhMucConRepository.findById(dto.getMaDmc())
                .orElseThrow(() -> new RuntimeException("Danh mục con không tồn tại"));
        entity.setDanhMucCon(dmc);

        SanPhamEntity saved = sanPhamRepository.save(entity);
        return sanPhamMapper.toDTO(saved);
    }

    @Override
    public SanPhamDTO updateSanPham(Integer id, SanPhamDTO dto) {
        SanPhamEntity entity = sanPhamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm"));
        entity.setTenSP(dto.getTenSP());
        entity.setMoTaSanPham(dto.getMoTaSanPham());
        entity.setPhanTramKhuyenMai(dto.getPhanTramKhuyenMai());

        if (dto.getMaDmc() != null) {
            DanhMucConEntity dmc = danhMucConRepository.findById(dto.getMaDmc())
                    .orElseThrow(() -> new RuntimeException("Danh mục con không tồn tại"));
            entity.setDanhMucCon(dmc);
        }
        SanPhamEntity saved = sanPhamRepository.save(entity);
        return sanPhamMapper.toDTO(saved);
    }

        @Override
        public void deleteSanPham (Integer id){
            sanPhamRepository.deleteById(id);
        }

        @Override
        public SanPhamDTO getById (Integer id){
            SanPhamEntity entity = sanPhamRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm"));
            return sanPhamMapper.toDTO(entity);
        }
    }


