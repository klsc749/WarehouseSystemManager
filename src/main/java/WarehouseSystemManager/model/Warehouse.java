package WarehouseSystemManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {
    private int id;
    private String location;
    private int companyId;
}
