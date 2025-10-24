package com.springboot.shopclother.api;


import com.springboot.shopclother.model.dto.SanPhamDTO;

import com.springboot.shopclother.sevice.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/admin/sanpham")
public class SanPhamApi {

    @Autowired
    private SanPhamService sanPhamService;

    // Create
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<SanPhamDTO> create(@RequestBody SanPhamDTO dto) {
        SanPhamDTO created = sanPhamService.createSanPham(dto);
        return ResponseEntity.ok(created);
    }

    // Update
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<SanPhamDTO> update(@PathVariable Integer id,
                                             @RequestBody SanPhamDTO dto) {
        SanPhamDTO updated = sanPhamService.updateSanPham(id, dto);
        return ResponseEntity.ok(updated);
    }

    // Get by id
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<SanPhamDTO> getById(@PathVariable Integer id) {
        SanPhamDTO dto = sanPhamService.getById(id);
        return ResponseEntity.ok(dto);
    }

    // Get all
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<SanPhamDTO>> getAll() {
        List<SanPhamDTO> list = sanPhamService.getAllSanPham();
        return ResponseEntity.ok(list);
    }

    // Delete
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        sanPhamService.deleteSanPham(id);
        return ResponseEntity.noContent().build();
    }
}
