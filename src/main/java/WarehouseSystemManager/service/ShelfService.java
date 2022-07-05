package WarehouseSystemManager.service;

import WarehouseSystemManager.mapper.ShelfMapper;
import WarehouseSystemManager.model.Shelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelfService {
    @Autowired
    private ShelfMapper shelfMapper;

    /**
     * get all shelves
     * @return a list of shelf objects
     */
    public List<Shelf> getAllShelf(){
        return shelfMapper.getALlShelf();
    }

    /**
     * get all shelves in a warehouse
     * @param warehouseId warehouse id
     * @return a list of warehouse objects
     */
    public List<Shelf> getShelfInWarehouse(int warehouseId){
        return shelfMapper.getShelfInWarehouse(warehouseId);
    }

    /**
     * get a shelf
     * @param shelfId shelf id
     * @return a shelf id
     */
    public Shelf getShelf(int shelfId){
        return shelfMapper.getShelf(shelfId);
    }

    /**
     * add a shelf
     * @param shelf a shelf object
     * @return true if it's added successfully
     */
    public boolean addShelf(Shelf shelf){
        return shelfMapper.addShelf(shelf) == 1;
    }
}
