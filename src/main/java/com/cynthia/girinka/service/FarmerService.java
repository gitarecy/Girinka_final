package com.cynthia.girinka.service;

import com.cynthia.girinka.model.Farmer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FarmerService {
    List<Farmer> getAllFarmers(); //display (READ)
    void saveFarmer(Farmer farmer); //save (CREATE)
    Farmer getFarmerById(Long id); //update by ID (UPDATE)
    void deleteFarmerById(Long id);
    Page<Farmer> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection); //pagination and Sorting

}
