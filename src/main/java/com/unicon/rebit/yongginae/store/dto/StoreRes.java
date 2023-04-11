package com.unicon.rebit.yongginae.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreRes {
    //    private Long id;
    private String storeName;
    private String address;
    private String category1;
    private String category2;
    private String tel;

//    public StoreRes(String storeName, String category1, String category2, String address, int tel) {
//        this.storeName = storeName;
//        this.category1 = category1;
//        this.category2 = category2;
//        this.address = address;
//        this.tel = tel;
//    }
}

