package WarehouseSystemManager.service;

import WarehouseSystemManager.mapper.CompanyMapper;
import WarehouseSystemManager.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    /**
     * add company
     * @param company the object of the company
     * @return true if it's added
     */
    public boolean addCompany(Company company){
        return companyMapper.addCompany(company) == 1;
    }

    /**
     * get all companies' information
     * @return a list of companies
     */
    public List<Company> getAllCompany(){
        return companyMapper.getAllCompany();
    }

}
