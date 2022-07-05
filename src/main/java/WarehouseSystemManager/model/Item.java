package WarehouseSystemManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private static final String ITEM_STATE_GERT_OUT = "gotOut";
    private static final String ITEM_STATE_STORED = "stored";

    private int id;
    private String name;
    private String category;
    private String state;
}
