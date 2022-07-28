package WarehouseSystemManager.controller;

import WarehouseSystemManager.model.RobotRequest;
import WarehouseSystemManager.service.RobotRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class RobotRequestController {

    @Autowired
    private RobotRequestService robotRequestService;

    @GetMapping("/get/getRobotsRequest")
    public List<RobotRequest> getRobotRequestInWarehouse(int warehouseId){
        return robotRequestService.getRobotRequestsInWarehouse(warehouseId);
    }
}
