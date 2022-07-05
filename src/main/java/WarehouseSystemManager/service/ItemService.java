package WarehouseSystemManager.service;

import WarehouseSystemManager.mapper.ItemMapper;
import WarehouseSystemManager.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemMapper itemMapper;

    /**
     * add a new item
     * @param item an object of item class
     * @return ture if successful
     */
    public boolean addItem(Item item){
        return itemMapper.addItem(item) == 1;
    }

    /**
     * get all items in a warehouse
     * @param warehouseId warehouse id
     * @return a list of item
     */
    public List<Item> getItemInWarehouse(int warehouseId){
        return itemMapper.getItemInWarehouse(warehouseId);
    }

    /**
     * get all items in a shelf
     * @param shelfId shelf id
     * @return a list of item
     */
    public List<Item> getItemInShelf(int shelfId){
        return itemMapper.getItemInShelf(shelfId);
    }

    /**
     * get all items in the given row of a shelf
     * @param shelfId shelf id
     * @param rowNum row number
     * @return a list of item
     */
    public List<Item> getItemInShelfRow(int shelfId, int rowNum){
        return itemMapper.getItemInShelfRow(shelfId, rowNum);
    }

    /**
     * get a item by its id
     * @param itemId item id
     * @return a item
     */
    public Item getItem(int itemId){
        return itemMapper.getItem(itemId);
    }
}
