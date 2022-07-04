package WarehouseSystemManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemStorageInfo {
    private int id;
    private int rowNum;
    private int colNum;
    private Date date;
    private int shelfId;
    private int itemId;
}
