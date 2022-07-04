package WarehouseSystemManager.service;

import WarehouseSystemManager.mapper.WorkerMapper;
import WarehouseSystemManager.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    @Autowired
    private WorkerMapper workerMapper;

    public int addWorker(Worker worker){
        if(checkAccountExist(worker.getAccountId())){
            return 0;
        }
        return workerMapper.addWorker(worker);
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
        System.out.println(workerMapper.checkAccountExist(accountId));
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
        String corrPassword = workerMapper.getPassWord(accountId);
        return corrPassword == encodedPassword;
    }
}
