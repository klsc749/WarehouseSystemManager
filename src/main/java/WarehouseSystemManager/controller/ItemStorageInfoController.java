package WarehouseSystemManager.controller;

import WarehouseSystemManager.model.ItemStorageInfo;
import WarehouseSystemManager.service.ItemStorageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ItemStorageInfoController {
    @Autowired
    private ItemStorageInfoService itemStorageInfoService;

    @PostMapping("/addItemStorageInfo")
    public HttpStatus addItemStorageInfo(@RequestBody ItemStorageInfo itemStorageInfo){
        return itemStorageInfoService.addItemStorageInfo(itemStorageInfo) ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
    }

    @GetMapping("/getItemStorageInfo")
    public List<ItemStorageInfo> getItemStorageInfo(@RequestParam("itemId") int itemId){
        return itemStorageInfoService.getItemStorageInfo(itemId);
    }
}
