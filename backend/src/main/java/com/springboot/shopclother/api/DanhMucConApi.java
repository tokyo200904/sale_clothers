package com.springboot.shopclother.api;

import com.springboot.shopclother.converter.DanhMucMapper;
import com.springboot.shopclother.entity.DanhMucConEntity;

import com.springboot.shopclother.model.dto.DanhMucConDTO;
import com.springboot.shopclother.sevice.DanhMucConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/danhmuccon")
@CrossOrigin(origins = "*")
public class DanhMucConApi {
    @Autowired
    private DanhMucConService danhMucConService;

    //lay all
    @GetMapping
    public ResponseEntity<List<DanhMucConDTO>> getAllDanhMucCon() {
        List<DanhMucConDTO> list = danhMucConService.getAllDanhMucCon()
                .stream()
                .map(DanhMucMapper::toDanhMucConDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }
// them
    @PostMapping("/add/{maDanhMuc}")
    public ResponseEntity<DanhMucConDTO> createDanhMucCon(
            @PathVariable Integer maDanhMuc,
            @RequestBody DanhMucConEntity danhMucCon) {
        DanhMucConEntity entity = danhMucConService.createDanhMucCon(maDanhMuc, danhMucCon);
        return ResponseEntity.ok(DanhMucMapper.toDanhMucConDTO(entity));
    }
//sua
    @PutMapping("/{id}")
    public ResponseEntity<DanhMucConDTO> updateDanhMucCon(
            @PathVariable Integer id,
            @RequestBody DanhMucConEntity danhMucCon) {
        DanhMucConEntity entity = danhMucConService.updateDanhMucCon(id, danhMucCon);
        return ResponseEntity.ok(DanhMucMapper.toDanhMucConDTO(entity));
    }

//xoa
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDanhMucCon(@PathVariable Integer id) {
        danhMucConService.deleteDanhMucCon(id);
        return ResponseEntity.ok("Xóa danh mục con thành công!");
    }
}
