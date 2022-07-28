package WarehouseSystemManager.service;

import WarehouseSystemManager.mapper.RobotMapper;
import WarehouseSystemManager.model.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RobotService {

    @Autowired
    private RobotMapper robotMapper;

    /**
     * get all robots in a warehouse
     * @param warehouseId
     * @return
     */
    public List<Robot> getRobotsInWarehouse(int warehouseId){
        return robotMapper.getRobotsInWarehouse(warehouseId);
    }
}
