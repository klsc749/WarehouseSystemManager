package WarehouseSystemManager.controller;

import WarehouseSystemManager.model.Worker;
import WarehouseSystemManager.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Worker> getAll(){
        return workerService.getAllWorker();
    }

    @RequestMapping(value = "/addWorker", method = RequestMethod.POST)
    public int addWorker(@RequestBody Worker worker){
        return workerService.addWorker(worker);
    }
}
