package com.unicon.rebit.yongginae.store.dto;

import com.unicon.rebit.yongginae.store.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreAllInfoRes {
    private Long storeId;
    private String storeName;
}
