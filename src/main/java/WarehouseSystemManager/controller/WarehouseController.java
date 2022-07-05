package WarehouseSystemManager.controller;

import WarehouseSystemManager.model.Warehouse;
import WarehouseSystemManager.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @RequestMapping(value = "/getAllWarehouse",method = RequestMethod.GET)
    public List<Warehouse> getAllWarehouse(){
        return warehouseService.getAllWarehouse();
    }

    @GetMapping("/getWarehouseInCompany")
    public List<Warehouse> getWarehouseInCompany(@RequestParam("companyId") int companyId){
        return warehouseService.getWarehouseInCompany(companyId);
    }

    @GetMapping("getWarehouse")
    public Warehouse gerWarehouse(@RequestParam("warehouseId") int warehouseId){
        return warehouseService.getWarehouse(warehouseId);
    }

    @PostMapping("addWarehouse")
    public HttpStatus addWarehouse(@RequestBody Warehouse warehouse){
        return warehouseService.addWarehouse(warehouse) ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
    }
}
