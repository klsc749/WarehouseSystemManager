package WarehouseSystemManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager {
    private int id;
    private String name;
    private String accountId;
    private String password;
    private int companyId;
}
