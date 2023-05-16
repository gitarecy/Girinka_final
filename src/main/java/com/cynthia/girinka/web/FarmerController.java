package com.cynthia.girinka.web;

import com.cynthia.girinka.model.Farmer;
import com.cynthia.girinka.service.Implementations.FarmerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FarmerController {
    @Autowired
    private FarmerServiceImpl farmerService;
   @GetMapping("/showFarmerPage")
    public String viewHomePage(Model model){
        return "index"; //REMEBER TO CHANGE INDEX WHEN YOU ADD THE HOMEPAGE*/
      }

    //display list of paginated farmers
    @GetMapping("/getfarmer")
    public String viewFarmerListPage(Model model){
       /* model.addAttribute("listFarmers", farmerService.getAllFarmers());
        return "index"; //REMEBER TO CHANGE INDEX WHEN YOU ADD THE HOMEPAGE*/
        return findPaginated(1, "firstName", "asc", model); //farmers will be sorted in ascending order
    }

    //SAVE farmer
        //1. getting the save page
    @GetMapping("/showNewFarmerForm")
    public String showNewFarmerForm(Model model){
        //connecting data from form to db
        Farmer farmer = new Farmer();
        model.addAttribute("farmer", farmer);
        return "newFarmerPage";
    }
        //2. for the save button
    @PostMapping("/saveFarmer")
    public String saveFarmer(@ModelAttribute("farmer") Farmer farmer){
        //save farmer to db
        farmerService.saveFarmer(farmer);
        return "redirect:/getfarmer"; //REMEMBER TO CHANGE REDIRECTION WHEN YOU CHANGE TO FARMERLISTPAGE!!!!!
    }

    //UPDATE farmer page
    //1. for the update page
    //2. Basically used the save codes too
    @GetMapping("/showUpdateFarmer/{id}")
    public String showUpdateFarmer(@PathVariable(value = "id") Long id, Model model){
        //get farmer from the service
        Farmer farmer = farmerService.getFarmerById(id);
        //set farmer as a model attribute to pre-populate the form
        model.addAttribute("farmer2", farmer);
        return "updateFarmer";
    }

    //DELETE farmer
    @GetMapping("/showDeleteFarmer/{id}")
    public String showDeleteFarmer(@PathVariable(value = "id") Long id){
    //call delete method from service impl
        this.farmerService.deleteFarmerById(id);
        return "redirect:/getfarmer"; //REMEMBER TO CHANGE THIS AS WELL TO NEW FARMERLISTPAGE!!!
    }
//Sorting and Pagination
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model){
                                int pageSize = 5;

        Page<Farmer> page = farmerService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Farmer> listFarmers = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listFarmers", listFarmers);

        return "index"; //REMEMBER TO CHANGE THIS AS WELL TO NEW FARMERLISTPAGE!!!
    }
}
