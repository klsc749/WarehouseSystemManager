package WarehouseSystemManager.controller;

import WarehouseSystemManager.model.Shelf;
import WarehouseSystemManager.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ShelfController {
    @Autowired
    private ShelfService shelfService;

    @GetMapping("/get/getAllShelf")
    public List<Shelf> getAllShelf(){
        return shelfService.getAllShelf();
    }

    @GetMapping("/get/getShelfInWarehouse")
    public List<Shelf> getShelfInWarehouse(@RequestParam("warehouseId") int warehouseId){
        return shelfService.getShelfInWarehouse(warehouseId);
    }

    @GetMapping("/get/getShelf")
    public Shelf getShelf(@RequestParam("shelfId") int shelfId){
        return shelfService.getShelf(shelfId);
    }

    @PostMapping("/add/addShelf")
    public HttpStatus addShelf(@RequestBody Shelf shelf){
        return shelfService.addShelf(shelf) ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
    }
}
