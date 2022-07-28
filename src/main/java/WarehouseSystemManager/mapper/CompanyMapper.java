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
    @Insert("INSERT INTO company(name, registerCode) VALUES (#{name}, #{registerCode})")
    public int addCompany(Company company);

    @Select("SELECT * FROM company")
    public List<Company> getAllCompany();

    @Select("SELECT * FROM company WHERE registerCode = #{registerCode}")
    public Company getCompany(String registerCode);
}
