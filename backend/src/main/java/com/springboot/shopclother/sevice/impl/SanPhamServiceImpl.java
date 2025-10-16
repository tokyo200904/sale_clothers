package com.springboot.shopclother.sevice.impl;


import com.springboot.shopclother.converter.SanPhamMapper;
import com.springboot.shopclother.entity.SanPhamEntity;
import com.springboot.shopclother.entity.SanPhamBtEntity;


import com.springboot.shopclother.model.dto.SanPhamDTO;
import com.springboot.shopclother.repository.SanPhamRepository;
import com.springboot.shopclother.sevice.CuaHangService;
import com.springboot.shopclother.sevice.DanhMucConService;
import com.springboot.shopclother.sevice.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private DanhMucConService danhMucConService;

    @Autowired
    private CuaHangService cuaHangService;

    @Autowired
    private SanPhamMapper sanPhamMapper;

    @Override
    public List<SanPhamDTO> getAllSanPham() {
        return sanPhamRepository.findAll()
                .stream()
                .map(sanPhamMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SanPhamDTO createSanPham(SanPhamDTO dto) {
        SanPhamEntity sanPham = sanPhamMapper.toEntity(dto);
        sanPham.setDanhMucCon(danhMucConService.getDanhMucConById(dto.getMaDmc()));
        sanPham.setCuaHang(cuaHangService.getCuaHangById(dto.getMaCH()));

        // convert chi tiết sản phẩm
        List<SanPhamBtEntity> bts = dto.getChiTietList().stream()
                .map(btDTO -> {
                    SanPhamBtEntity bt = new SanPhamBtEntity();
                    bt.setChatLieuSanPham(btDTO.getChatLieuSanPham());
                    bt.setKichCo(btDTO.getKichCo());
                    bt.setMauSac(btDTO.getMauSac());
                    bt.setSoLuongTrongKho(btDTO.getSoLuongTrongKho());
                    bt.setGiaSanPham(btDTO.getGiaSanPham());
                    bt.setAnh(btDTO.getAnh());
                    bt.setSanPham(sanPham);
                    return bt;
                }).collect(Collectors.toList());

        sanPham.setSanPhamBts(bts);
        SanPhamEntity saved = sanPhamRepository.save(sanPham);
        return sanPhamMapper.toDTO(saved);
    }

    @Override
    public SanPhamDTO updateSanPham(Integer id, SanPhamDTO dto) {
        SanPhamEntity sanPham = sanPhamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm!"));

        sanPham.setTenSP(dto.getTenSP());
        sanPham.setMoTaSanPham(dto.getMoTaSanPham());
        sanPham.setPhanTramKhuyenMai(dto.getPhanTramKhuyenMai());
        sanPham.setDanhMucCon(danhMucConService.getDanhMucConById(dto.getMaDmc()));
        sanPham.setCuaHang(cuaHangService.getCuaHangById(dto.getMaCH()));

        // Xóa chi tiết cũ
        sanPham.getSanPhamBts().clear();

        List<SanPhamBtEntity> bts = dto.getChiTietList().stream()
                .map(btDTO -> {
                    SanPhamBtEntity bt = new SanPhamBtEntity();
                    bt.setChatLieuSanPham(btDTO.getChatLieuSanPham());
                    bt.setKichCo(btDTO.getKichCo());
                    bt.setMauSac(btDTO.getMauSac());
                    bt.setSoLuongTrongKho(btDTO.getSoLuongTrongKho());
                    bt.setGiaSanPham(btDTO.getGiaSanPham());
                    bt.setAnh(btDTO.getAnh());
                    bt.setSanPham(sanPham);
                    return bt;
                }).collect(Collectors.toList());

        sanPham.setSanPhamBts(bts);
        SanPhamEntity updated = sanPhamRepository.save(sanPham);
        return sanPhamMapper.toDTO(updated);
    }

    @Override
    public void deleteSanPham(Integer id) {
        if (!sanPhamRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy sản phẩm để xóa!");
        }
        sanPhamRepository.deleteById(id);
    }
}
