package com.springboot.shopclother.api;
import com.springboot.shopclother.model.dto.SanPhamBtDTO;

import com.springboot.shopclother.sevice.SanPhamBtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sanphambt")
public class SanPhamBtapi {
        @Autowired
        private SanPhamBtService sanPhamBtService;

        // Create
        @PostMapping("/{id}")
        public ResponseEntity<SanPhamBtDTO> create(@PathVariable Integer id
                                                  ,@RequestBody SanPhamBtDTO dto) {
            SanPhamBtDTO created = sanPhamBtService.createSanPhamBt(id,dto);
            return ResponseEntity.ok(created);
        }

        // Update
        @PutMapping("/{id}")
        public ResponseEntity<SanPhamBtDTO> update(@PathVariable Integer id,
                                                   @RequestBody SanPhamBtDTO dto) {
            SanPhamBtDTO updated = sanPhamBtService.updateSanPham(id, dto);
            return ResponseEntity.ok(updated);
        }

        // Get by id
        @GetMapping("/{id}")
        public ResponseEntity<SanPhamBtDTO> getById(@PathVariable Integer id) {
            SanPhamBtDTO dto = sanPhamBtService.getByIdSanPhamBt(id);
            return ResponseEntity.ok(dto);
        }

        // Get all chi tiết của 1 sản phẩm
        @GetMapping("/sanpham/{maSP}")
        public ResponseEntity<List<SanPhamBtDTO>> getBySanPham(@PathVariable Integer maSP) {
            List<SanPhamBtDTO> list = sanPhamBtService.getBySanPhamId(maSP);
            return ResponseEntity.ok(list);
        }

        // Delete
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Integer id) {
            sanPhamBtService.deleteSanPhamBt(id);
            return ResponseEntity.noContent().build();
        }
}
