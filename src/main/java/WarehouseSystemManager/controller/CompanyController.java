package WarehouseSystemManager.controller;

import WarehouseSystemManager.model.Company;
import WarehouseSystemManager.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/get/getAllCompany", method = RequestMethod.GET)
    public List<Company> getAllCompany(){
        return companyService.getAllCompany();
    }

    @RequestMapping(value = "/add/addCompany", method = RequestMethod.POST)
    public HttpStatus addCompany(@RequestBody Company company){
        return companyService.addCompany(company) ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
    }

}
