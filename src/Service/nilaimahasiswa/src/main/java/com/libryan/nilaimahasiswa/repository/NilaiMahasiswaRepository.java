/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libryan.nilaimahasiswa.repository;

import com.libryan.nilaimahasiswa.entity.NilaiMahasiswa;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Modern 14
 */

@Repository
public interface NilaiMahasiswaRepository extends JpaRepository<NilaiMahasiswa, Long> {

    public Optional<NilaiMahasiswa> findNilaiById(Long id);
    
}
