package WarehouseSystemManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RobotRequest {
    private int id;
    private String host;
    private int dataSize;
    private Timestamp time;
    private String acceptState;
    private int robotId;
}
