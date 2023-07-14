package com.unicon.rebit.yongginae.store.dto;

import com.unicon.rebit.yongginae.store.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreSearchNameRes {
    private String storeName;
    private Long storeIid;

    public StoreSearchNameRes(Store store) {
        storeName = store.getAddress();
        storeIid = store.getId();
    }
}