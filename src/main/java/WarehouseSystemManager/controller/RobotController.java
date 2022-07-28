package WarehouseSystemManager.controller;

import WarehouseSystemManager.model.Robot;
import WarehouseSystemManager.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class RobotController {

    @Autowired
    private RobotService robotService;

    @GetMapping("/get/getRobotsInWarehouse")
    public List<Robot> getRobotsInWarehouse(@RequestParam("warehouseId") int warehouse){
        return  robotService.getRobotsInWarehouse(warehouse);
    }
}
