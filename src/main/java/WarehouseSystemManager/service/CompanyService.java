package WarehouseSystemManager.service;

import WarehouseSystemManager.common.MD5Util;
import WarehouseSystemManager.mapper.CompanyMapper;
import WarehouseSystemManager.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
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
        company.setRegisterCode(this.getRegisterCode());
        return companyMapper.addCompany(company) == 1;
    }

    /**
     * get all companies' information
     * @return a list of companies
     */
    public List<Company> getAllCompany(){
        return companyMapper.getAllCompany();
    }

    public Company getCompany(String registerCode){
        return companyMapper.getCompany(registerCode);
    }

    private String getRegisterCode(){
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return MD5Util.md5(timestamp.toString());
    }

}
