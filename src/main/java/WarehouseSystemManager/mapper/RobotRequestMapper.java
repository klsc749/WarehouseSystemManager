package WarehouseSystemManager.mapper;

import WarehouseSystemManager.model.RobotRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RobotRequestMapper {
    @Insert("INSERT INTO robotRequest(host, dataSize, time, acceptState, robotId) Values" +
            " (#{host}, #{dataSize}, #{time}, #{acceptState}, #{robotId})")
    public int addRobotRequest(RobotRequest robotRequest);

    @Select("SELECT * FROM robotRequest WHERE robotId in " +
            "(SELECT id FROM robot WHERE warehouseId = #{warehouseId})")
    public List<RobotRequest> getRobotRequestsInWarehouse(int warehouseId);
}
