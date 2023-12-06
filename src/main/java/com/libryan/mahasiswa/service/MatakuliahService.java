/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libryan.mahasiswa.service;

import com.libryan.mahasiswa.entity.Matakuliah;
import com.libryan.mahasiswa.repository.MatakuliahRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Modern 14
 */
@Service
public class MatakuliahService {
    @Autowired
    private MatakuliahRepository matakuliahRepository;
    
    public void insert(Matakuliah matakuliah) {
        Optional<Matakuliah> mhsOptional = 
                matakuliahRepository.findMatakuliahByKode(matakuliah.getKode());
        if (mhsOptional.isPresent()) {
            throw new IllegalStateException("Email sudah ada");
        }
        matakuliahRepository.save(matakuliah);
    }
    
    public List<Matakuliah> getAll() {
        return matakuliahRepository.findAll();
    }
    
}
