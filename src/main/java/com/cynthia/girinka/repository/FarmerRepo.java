package com.cynthia.girinka.repository;

import com.cynthia.girinka.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRepo extends JpaRepository<Farmer, Long> {
}
