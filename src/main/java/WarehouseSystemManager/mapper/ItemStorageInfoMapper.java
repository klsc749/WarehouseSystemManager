package WarehouseSystemManager.mapper;

import WarehouseSystemManager.model.ItemStorageInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ItemStorageInfoMapper {

    @Select("SELECT * FROM itemStorageInfo where itemId = #{itemId} ORDER BY date")
    public List<ItemStorageInfo> getItemStorageInfo(int itemId);

    @Insert("INSERT INTO `itemStorageInfo` (`rowNum`, `storeNum`, `date`,`shelfId`, `itemId`) " +
            "VALUES (#{rowNum}, #{storeNum}, now(), #{shelfId}, #{itemId})")
    public int addItemStorageInfo(ItemStorageInfo itemStorageInfo);
}
