/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libryan.nilaimahasiswa.controller;

import com.libryan.nilaimahasiswa.entity.NilaiMahasiswa;
import com.libryan.nilaimahasiswa.service.NilaiMahasiswaService;
import com.libryan.nilaimahasiswa.vo.ResponseTemplate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Modern 14
 */

@RestController
@RequestMapping("api/v1/nilai")
public class NilaiMahasiswaController {
    @Autowired
    public NilaiMahasiswaService nilaiService;
    
    @GetMapping
    public List<NilaiMahasiswa> getAll() {
        return nilaiService.getAll();
    }
    
    @PostMapping()
    public void insert(@RequestBody NilaiMahasiswa nilai) {
        nilaiService.insert(nilai);
    }
    
    @GetMapping(path = "{id}")
    public ResponseTemplate getMahasiswaById(@PathVariable("id") Long id){
        return nilaiService.getNilaiById(id);
    }
    
    @PutMapping(path = "{id}")
    public void update(@PathVariable("id") Long id, @RequestBody NilaiMahasiswa nilai) {
        nilai.setId(id);

        nilaiService.update(nilai);
    }
}
