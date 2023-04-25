package com.unicon.rebit.yongginae.store.dto;

import com.unicon.rebit.yongginae.review.ReviewSearchRes;
import com.unicon.rebit.yongginae.store.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreSearchRes {
    private String storeName;
    private String address;
    private String category1;
    private String category2;
    private String tel;
    private String store_photo;

    private List<ReviewSearchRes> reviewSearchResList = new ArrayList<>();

    public StoreSearchRes(Store store) {
        this.storeName = store.getStoreName();
        this.address = store.getAddress();
        this.category1 = store.getCategory1();
        this.category2 = store.getCategory2();
        this.tel = store.getTel();
        this.store_photo = store.getStore_photo();
    }

    public StoreSearchRes(Store store, List<ReviewSearchRes> reviewSearchResList) {
        this(store);
        this.reviewSearchResList = reviewSearchResList;
    }
}