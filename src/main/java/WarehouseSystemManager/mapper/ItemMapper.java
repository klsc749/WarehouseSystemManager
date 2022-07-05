package WarehouseSystemManager.mapper;

import WarehouseSystemManager.model.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ItemMapper {

    @Select("SELECT * FROM ITEM")
    public List<Item> getAllItem();

    //TODO 联表查询
    @Select("SELECT * FROM item WHERE state=\"stored\" AND id IN " +
            "(SELECT itemId FROM itemStorageInfo WHERE (itemId, `date`) IN " +
            "(SELECT itemId, MAX(`date`) FROM itemStorageInfo GROUP BY itemId) " +
            "AND shelfId IN " +
            "(SELECT id FROM shelf WHERE warehouseId=#{warehouseId}))")
    public List<Item> getItemInWarehouse(int warehouseId);

    @Select("SELECT * FROM item WHERE state=\"stored\" AND id IN " +
            "(SELECT itemId FROM itemStorageInfo WHERE (itemId, `date`) IN " +
            "(SELECT itemId, MAX(`date`) FROM itemStorageInfo GROUP BY itemId) " +
            "AND shelfId=#{shelfId})")
    public List<Item> getItemInShelf(int shelfId);

    @Select("SELECT * FROM item WHERE state=\"stored\" AND id IN " +
            "(SELECT itemId FROM itemStorageInfo WHERE (itemId, `date`) IN " +
            "(SELECT itemId, MAX(`date`) FROM itemStorageInfo GROUP BY itemId) " +
            "AND shelfId=#{shelfId} AND rowNum=#{rowNum})")
    public List<Item> getItemInShelfRow(int shelfId, int rowNum);

    @Select("SELECT * FROM item WHERE id=#{itemId}")
    public Item getItem(int itemId);

    @Insert("INSERT INTO item(name, category, state) " +
            "VALUES (#{name}, #{category}, #{state})")
    public int addItem(Item item);
}
