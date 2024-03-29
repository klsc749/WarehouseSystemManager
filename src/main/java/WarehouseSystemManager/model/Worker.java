package WarehouseSystemManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Worker {
    private int id;
    private String userName;
    private String accountId;
    private String password;
    private String salt;
    private int companyId;
    private int warehouseId;
}
