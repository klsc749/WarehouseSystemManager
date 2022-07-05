package WarehouseSystemManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemStorageInfo {
    private int id;
    private int rowNum;
    private int storeNum;
    private Timestamp date;
    private int shelfId;
    private int itemId;
}
