package WarehouseSystemManager.service;

import WarehouseSystemManager.mapper.ItemStorageInfoMapper;
import WarehouseSystemManager.model.ItemStorageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class ItemStorageInfoService {
    @Autowired
    private ItemStorageInfoMapper itemStorageInfoMapper;

    public List<ItemStorageInfo> getItemStorageInfo(int itemId){
        return itemStorageInfoMapper.getItemStorageInfo(itemId);
    }

    public boolean addItemStorageInfo(ItemStorageInfo itemStorageInfo){
        Date date = new Date();
        itemStorageInfo.setDate(new Timestamp(date.getTime()));
        return itemStorageInfoMapper.addItemStorageInfo(itemStorageInfo) == 1;
    }
}
