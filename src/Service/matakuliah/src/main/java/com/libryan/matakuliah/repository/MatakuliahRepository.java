/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.libryan.matakuliah.repository;

import com.libryan.matakuliah.entity.Matakuliah;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Modern 14
 */
@Repository
public interface MatakuliahRepository extends JpaRepository<Matakuliah, Long>{

    public Optional<Matakuliah> findMatakuliahByKode(String kode);

}
