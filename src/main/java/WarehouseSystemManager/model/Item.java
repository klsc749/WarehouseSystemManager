package WarehouseSystemManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private static final String ITEM_STATE_GERT_OUT = "GetOut";
    private static final String ITEM_STATE_STORED = "Store";

    private int id;
    private String name;
    private String type;
    private String state;
}
