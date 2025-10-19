package com.springboot.shopclother.api;


import com.springboot.shopclother.model.dto.SanPhamDTO;

import com.springboot.shopclother.sevice.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sanpham")
public class SanPhamApi {

    @Autowired
    private SanPhamService sanPhamService;

    // Create
    @PostMapping
    public ResponseEntity<SanPhamDTO> create(@RequestBody SanPhamDTO dto) {
        SanPhamDTO created = sanPhamService.createSanPham(dto);
        return ResponseEntity.ok(created);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<SanPhamDTO> update(@PathVariable Integer id,
                                             @RequestBody SanPhamDTO dto) {
        SanPhamDTO updated = sanPhamService.updateSanPham(id, dto);
        return ResponseEntity.ok(updated);
    }

    // Get by id
    @GetMapping("/{id}")
    public ResponseEntity<SanPhamDTO> getById(@PathVariable Integer id) {
        SanPhamDTO dto = sanPhamService.getById(id);
        return ResponseEntity.ok(dto);
    }

    // Get all
    @GetMapping
    public ResponseEntity<List<SanPhamDTO>> getAll() {
        List<SanPhamDTO> list = sanPhamService.getAllSanPham();
        return ResponseEntity.ok(list);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        sanPhamService.deleteSanPham(id);
        return ResponseEntity.noContent().build();
    }
}
