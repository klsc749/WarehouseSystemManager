package WarehouseSystemManager.service;

import WarehouseSystemManager.mapper.RobotRequestMapper;
import WarehouseSystemManager.model.RobotRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RobotRequestService {

    @Autowired
    private RobotRequestMapper robotRequestMapper;

    public int addRobotRequest(RobotRequest robotRequest){
        return robotRequestMapper.addRobotRequest(robotRequest);
    }

    public List<RobotRequest> getRobotRequestsInWarehouse(int warehouseId){
        return robotRequestMapper.getRobotRequestsInWarehouse(warehouseId);
    }
}
