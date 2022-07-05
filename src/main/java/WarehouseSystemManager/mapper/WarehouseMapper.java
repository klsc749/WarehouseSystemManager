package WarehouseSystemManager.mapper;

import WarehouseSystemManager.model.Warehouse;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WarehouseMapper {

    @Select("SELECT * FROM warehouse")
    public List<Warehouse> getAllWarehouse();

    @Select("SELECT * FROM warehouse where companyId = #{companyId}")
    public List<Warehouse> getWarehouseInCompany(int companyId);

    @Select("SELECT * FROM warehouse where id = #{warehouseId}")
    public Warehouse getWarehouse(int warehouseId);

    @Insert("INSERT INTO warehouse(location, shelfNum, companyId) " +
            "VALUES (#{location}, #{shelfNum}, #{companyId})")
    public int addWarehouse(Warehouse warehouse);

    @Update("UPDATE warehouse SET shelfNum = #{shelfNum + 1} WHERE id = #{id};")
    public int addShelfNum(Warehouse warehouse);
}
