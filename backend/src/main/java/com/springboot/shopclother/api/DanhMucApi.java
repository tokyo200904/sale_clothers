package com.springboot.shopclother.api;


import com.springboot.shopclother.converter.DanhMucMapper;
import com.springboot.shopclother.entity.DanhMucEntity;


import com.springboot.shopclother.entity.DanhMucEntity;

import com.springboot.shopclother.model.dto.DanhMucDTO;
import com.springboot.shopclother.sevice.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/danhmuc")
@CrossOrigin(origins = "*")
public class DanhMucApi {

    @Autowired
    private DanhMucService danhMucService;

//lay all
    @GetMapping
    public ResponseEntity<List<DanhMucDTO>> getAllDanhMuc() {
        List<DanhMucDTO> list = danhMucService.getAllDanhMuc()
                .stream()
                .map(DanhMucMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }


//tao
    @PostMapping
    public ResponseEntity<DanhMucDTO> createDanhMuc(@RequestBody DanhMucEntity danhMuc) {
        return ResponseEntity.ok(DanhMucMapper.toDTO(danhMucService.createDanhMuc(danhMuc)));
    }
//sua
    @PutMapping("/{id}")
    public ResponseEntity<DanhMucDTO> updateDanhMuc(@PathVariable Integer id,
                                                    @RequestBody DanhMucEntity danhMuc) {
        return ResponseEntity.ok(DanhMucMapper.toDTO(danhMucService.updateDanhMuc(id, danhMuc)));
    }

//xoa
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDanhMuc(@PathVariable Integer id) {
        danhMucService.deleteDanhMuc(id);
        return ResponseEntity.ok("Xóa danh mục thành công!");
    }
}
