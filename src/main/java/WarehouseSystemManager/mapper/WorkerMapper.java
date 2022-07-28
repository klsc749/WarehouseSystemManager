package WarehouseSystemManager.mapper;

import WarehouseSystemManager.model.Worker;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WorkerMapper {
    // get all workers information
    @Select("SELECT * FROM worker")
    public List<Worker> getAllWorkers();

    //create a new worker
    @Insert("INSERT INTO worker(`userName`, `accountId`, `password`, `companyId`, `warehouseId`, `salt`) " +
            "VALUES (#{userName}, #{accountId}, #{password}, #{companyId}, #{warehouseId}, #{salt})")
    public int addWorker(Worker worker);

    @Select("SELECT id FROM worker WHERE accountId = #{accountId}")
    public List<String> checkAccountExist(String accountId);

    @Select("SELECT * FROM worker WHERE accountId=#{accountId}")
    public Worker getWorker(String accountId);

}
