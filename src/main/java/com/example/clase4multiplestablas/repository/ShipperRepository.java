package com.example.clase4multiplestablas.repository;

import com.example.clase4multiplestablas.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Integer> {

    List<Shipper> findByCompanyName(String nombre);

    @Query(value = "select * from shippers where CompanyName = ?1",
            nativeQuery = true)
    List<Shipper> buscarTransPorCompName(String nombre);


}

