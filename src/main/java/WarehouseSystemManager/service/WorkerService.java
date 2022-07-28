package WarehouseSystemManager.service;

import WarehouseSystemManager.common.MD5Util;
import WarehouseSystemManager.mapper.WorkerMapper;
import WarehouseSystemManager.model.Company;
import WarehouseSystemManager.model.Warehouse;
import WarehouseSystemManager.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class WorkerService {
    @Autowired
    private WorkerMapper workerMapper;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private WarehouseService warehouseService;

    public boolean addWorker(Worker worker){
        if(checkAccountExist(worker.getAccountId())){
            return false;
        }
        return workerMapper.addWorker(worker) == 1;
    }

    /**
     * get all workers' information
     * @return a list contain the workers information
     */
    public List<Worker> getAllWorker(){
        return workerMapper.getAllWorkers();
    }

    /**
     * Check whether the account exists
     * @param accountId the account id of the user
     * @return ture if the account exits
     */
    public boolean checkAccountExist(String accountId){
        return workerMapper.checkAccountExist(accountId).size() == 1;
    }

    /**
     * Check whether the password encoded by md5 is correct
     * @param accountId the account id of the worker
     * @param encodedPassword the encoded password
     * @return true if the password is correct
     */
    public boolean checkPassword(String accountId, String encodedPassword){
        //TODO: Add md5 encode
        Worker worker = workerMapper.getWorker(accountId);
        if(worker==null){
            return false;
        }
        String corrPassword = MD5Util.md5(worker.getPassword()+worker.getSalt());
        encodedPassword = MD5Util.md5(encodedPassword + worker.getSalt());
        return Objects.equals(corrPassword, encodedPassword);
    }

    public String Register(Worker worker, String companyRegisterCode, String warehouseRegisterCode){
        if(checkAccountExist(worker.getAccountId())){
            return "The account id already exists";
        }
        Warehouse warehouse = warehouseService.getWarehouse(warehouseRegisterCode);
        System.out.println(warehouseRegisterCode);
        if(warehouse == null){
            return "Warehouse register code is wrong";
        }
        Company company = companyService.getCompany(companyRegisterCode);
        if(company == null){
            return "Company register code is wrong";
        }
        worker.setWarehouseId(warehouse.getId());
        worker.setCompanyId(company.getId());
        worker.setSalt(MD5Util.getSalt());
        return workerMapper.addWorker(worker) == 1 ? "Register successfully" : "Fail to register";
    }
}
