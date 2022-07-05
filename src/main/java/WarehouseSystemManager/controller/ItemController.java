package WarehouseSystemManager.controller;

import WarehouseSystemManager.model.Item;
import WarehouseSystemManager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/addItem")
    public HttpStatus addItem(@RequestBody Item item){
        return itemService.addItem(item) ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
    }

    @GetMapping("/getItemInWarehouse")
    public List<Item> getItemInWarehouse(@RequestParam("warehouseId") int warehouseId){
        return itemService.getItemInWarehouse(warehouseId);
    }

    @GetMapping("/getItemInShelf")
    public List<Item> getItemInShelf(@RequestParam("shelfId") int shelfId){
        return itemService.getItemInShelf(shelfId);
    }

    @GetMapping("/getItemInShelfRow")
    public List<Item> getItemInShelfRow(@RequestParam("shelfId") int shelfId, @RequestParam("rowNum") int rowNum){
        return itemService.getItemInShelfRow(shelfId, rowNum);
    }

    @GetMapping("/getItem")
    public Item getItem(@RequestParam("itemId") int itemId){
        return itemService.getItem(itemId);
    }
}
