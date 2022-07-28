package WarehouseSystemManager.mapper;

import WarehouseSystemManager.model.Robot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RobotMapper {

    @Select("SELECT * FROM robot WHERE warehouseId = #{warehouseId}")
    public List<Robot> getRobotsInWarehouse(int warehouseId);
}
