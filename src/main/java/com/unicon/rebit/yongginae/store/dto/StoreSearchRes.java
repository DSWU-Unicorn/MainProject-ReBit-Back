package com.unicon.rebit.yongginae.store.dto;

import com.unicon.rebit.yongginae.store.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreSearchRes {
    //    private Long id;
    private String storeName;
    private String address;
    private String category1;
    private String category2;
    private String tel;

    public StoreSearchRes(Store store) {
        storeName = store.getStoreName();
        address = store.getAddress();
        category1 = store.getCategory1();
        category2 = store.getCategory2();
        tel = store.getTel();
    }
}

