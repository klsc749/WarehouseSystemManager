package WarehouseSystemManager.mapper;

import WarehouseSystemManager.model.Shelf;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShelfMapper {
    @Select("SELECT * FROM shelf")
    public List<Shelf> getALlShelf();

    @Select("SELECT * FROM shelf WHERE warehouseId=#{warehouseId}")
    public List<Shelf> getShelfInWarehouse(int warehouseId);

    @Select("SELECT * FROM shelf WHERE id=#{shelfId}")
    public Shelf getShelf(int shelfId);

    @Insert("INSERT INTO shelf(rowNum, warehouseId) " +
            "VALUES (#{rowNum}, #{warehouseId})")
    public int addShelf(Shelf shelf);
}
