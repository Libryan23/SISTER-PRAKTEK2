/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libryan.nilaimahasiswa.service;

import com.libryan.nilaimahasiswa.entity.NilaiMahasiswa;
import com.libryan.nilaimahasiswa.repository.NilaiMahasiswaRepository;
import com.libryan.nilaimahasiswa.vo.Mahasiswa;
import com.libryan.nilaimahasiswa.vo.Matakuliah;
import com.libryan.nilaimahasiswa.vo.ResponseTemplate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Modern 14
 */

@Service
public class NilaiMahasiswaService {
    @Autowired
    private NilaiMahasiswaRepository nilaiMahasiswaRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public void insert(NilaiMahasiswa nilai){
        Optional<NilaiMahasiswa> mhsOptional = nilaiMahasiswaRepository.findNilaiById(nilai.getId());
        if (mhsOptional.isPresent()) {
            throw new IllegalStateException("Matakuliah sudah ada");
        }
        nilaiMahasiswaRepository.save(nilai);
    }
    
    
    public List<NilaiMahasiswa> getAll(){
        return nilaiMahasiswaRepository.findAll();
    }
    
    public  ResponseTemplate getNilaiById(Long id){
        ResponseTemplate vo = new ResponseTemplate();
        NilaiMahasiswa nilai = nilaiMahasiswaRepository.findById(id).get();
        Mahasiswa mahasiswa = restTemplate.getForObject("http://localhost:9001/api/v1/mahasiswa/"+nilai.getIdmahasiswa(), Mahasiswa.class);
        Matakuliah matakuliah = restTemplate.getForObject("http://localhost:9002/api/v1/matakuliah/"+nilai.getIdmatakuliah(), Matakuliah.class);
        
        vo.setNilai(nilai);
        vo.setMahasiswa(mahasiswa);
        vo.setMatakuliah(matakuliah);
        return vo;
    }
    
    public void update(NilaiMahasiswa nilai) {
        Long id = nilai.getId();
        Optional<NilaiMahasiswa> existingNilaiOptional = nilaiMahasiswaRepository.findById(id);

        if (existingNilaiOptional.isPresent()) {
            NilaiMahasiswa existingNilai = existingNilaiOptional.get();

            existingNilai.setNilai(nilai.getNilai());
            existingNilai.setIdmahasiswa(nilai.getIdmahasiswa());
            existingNilai.setIdmatakuliah(nilai.getIdmatakuliah());

            nilaiMahasiswaRepository.save(existingNilai);
        } else {
            throw new IllegalStateException("Mahasiswa dengan id " + id + " tidak ditemukan");
        }
    }
}
