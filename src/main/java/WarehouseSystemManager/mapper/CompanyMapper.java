package WarehouseSystemManager.mapper;

import WarehouseSystemManager.model.Company;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CompanyMapper {
    @Insert("INSERT INTO company(name) VALUES (#{name})")
    public int addCompany(Company company);

    @Select("SELECT * FROM Company")
    public List<Company> getAllCompany();
}
