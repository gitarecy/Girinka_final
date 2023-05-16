package com.cynthia.girinka.service.Implementations;

import com.cynthia.girinka.model.Farmer;
import com.cynthia.girinka.repository.FarmerRepo;
import com.cynthia.girinka.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmerServiceImpl implements FarmerService{

    @Autowired
    private FarmerRepo farmerRepo;
    @Override
    public List<Farmer> getAllFarmers() {
        return farmerRepo.findAll();
    }

    @Override
    public void saveFarmer(Farmer farmer) {
        this.farmerRepo.save(farmer);
    }

    @Override
    public Farmer getFarmerById(Long id) {
        Optional<Farmer> optional = farmerRepo.findById(id);
        Farmer farmer = null;
        if(optional.isPresent()){
            farmer = optional.get();
        }else {
            throw new RuntimeException("Farmer not found :: " + id);
        }
        return farmer;
    }

    @Override
    public void deleteFarmerById(Long id) {
        this.farmerRepo.deleteById(id);
    }

    @Override
    public Page<Farmer> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo -1, pageSize, sort);
        return this.farmerRepo.findAll(pageable);
    }
}
