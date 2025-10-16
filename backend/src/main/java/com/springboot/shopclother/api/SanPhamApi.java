package com.springboot.shopclother.api;

import com.springboot.shopclother.model.dto.SanPhamDTO;
import com.springboot.shopclother.sevice.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sanpham")
@CrossOrigin(origins = "*")
public class SanPhamApi {
    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping
    public ResponseEntity<List<SanPhamDTO>> getAllSanPham() {
        return ResponseEntity.ok(sanPhamService.getAllSanPham());
    }

    @PostMapping
    public ResponseEntity<SanPhamDTO> createSanPham(@RequestBody SanPhamDTO dto) {
        return ResponseEntity.ok(sanPhamService.createSanPham(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SanPhamDTO> updateSanPham(@PathVariable Integer id, @RequestBody SanPhamDTO dto) {
        return ResponseEntity.ok(sanPhamService.updateSanPham(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSanPham(@PathVariable Integer id) {
        sanPhamService.deleteSanPham(id);
        return ResponseEntity.ok("Xóa sản phẩm thành công!");
    }
}
