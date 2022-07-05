package WarehouseSystemManager.service;

import WarehouseSystemManager.mapper.WarehouseMapper;
import WarehouseSystemManager.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseMapper warehouseMapper;

    /**
     * get all warehouses in all companies
     * @return a list of warehouse objects
     */
    public List<Warehouse> getAllWarehouse(){
        return warehouseMapper.getAllWarehouse();
    }

    /**
     * get all warehouse in a company
     * @param companyId company id
     * @return a list of warehouse objects
     */
    public List<Warehouse> getWarehouseInCompany(int companyId){
        return warehouseMapper.getWarehouseInCompany(companyId);
    }

    /**
     * get a warehouse by warehouse id
     * @param warehouseId warehouse id
     * @return a warehouse object
     */
    public Warehouse getWarehouse(int warehouseId){
        return warehouseMapper.getWarehouse(warehouseId);
    }

    /**
     * add the number shelf by 1
     * @param warehouseId warehouse id
     * @return true if success
     */
    public boolean addShelfNum(int warehouseId){
        return warehouseMapper.addShelfNum(getWarehouse(warehouseId)) == 1;
    }

    /**
     * add a warehouse
     * @param warehouse a warehouse object
     * @return true if the warehouse is added
     */
    public boolean addWarehouse(Warehouse warehouse){
        return warehouseMapper.addWarehouse(warehouse) == 1;
    }
}
