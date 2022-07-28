package WarehouseSystemManager.controller;

import WarehouseSystemManager.model.Worker;
import WarehouseSystemManager.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @RequestMapping(value = "/get/getAllWorker", method = RequestMethod.GET)
    public List<Worker> getAll(){
        return workerService.getAllWorker();
    }

    @RequestMapping(value = "/add/addWorker", method = RequestMethod.POST)
    public String addWorker(@RequestBody Worker worker, @RequestParam("companyRegisterCode") String companyRegisterCode, @RequestParam("warehouseRegisterCode") String warehouseRegisterCode){
        return workerService.Register(worker, companyRegisterCode, warehouseRegisterCode);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public boolean login(@RequestParam("accountId") String accountId, @RequestParam("password") String password){
        return workerService.checkPassword(accountId, password);
    }
}
