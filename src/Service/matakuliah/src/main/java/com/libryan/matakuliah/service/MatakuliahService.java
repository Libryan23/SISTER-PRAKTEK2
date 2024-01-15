/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libryan.matakuliah.service;

import com.libryan.matakuliah.entity.Matakuliah;
import com.libryan.matakuliah.repository.MatakuliahRepository;
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
    
    public void insert(Matakuliah matakuliah){
        Optional<Matakuliah> mhsOptional = matakuliahRepository.findMatakuliahByKode(matakuliah.getKode());
        if (mhsOptional.isPresent()) {
            throw new IllegalStateException("Matakuliah sudah ada");
        }
        matakuliahRepository.save(matakuliah);
    }
    
    
    public List<Matakuliah> getAll(){
        return matakuliahRepository.findAll();
    }
    
    public Matakuliah getMatakuliahById(Long id) {
        return matakuliahRepository.findById(id).get();
    }
    
    public void delete(Long id) {
        matakuliahRepository.deleteById(id);
    }
    
    public void update(Matakuliah matakuliah) {
        Long id = matakuliah.getId();
        Optional<Matakuliah> existingMatakuliahOptional = matakuliahRepository.findById(id);

        if (existingMatakuliahOptional.isPresent()) {
            Matakuliah existingMatakuliah = existingMatakuliahOptional.get();

            existingMatakuliah.setNama(matakuliah.getNama());
            existingMatakuliah.setKode(matakuliah.getKode());
            existingMatakuliah.setSks(matakuliah.getSks());

            matakuliahRepository.save(existingMatakuliah);
        } else {
            throw new IllegalStateException("Mahasiswa dengan id " + id + " tidak ditemukan");
        }
    }
}
