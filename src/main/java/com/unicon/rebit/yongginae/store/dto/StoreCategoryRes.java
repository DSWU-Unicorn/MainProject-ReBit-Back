package com.unicon.rebit.yongginae.store.dto;

import com.unicon.rebit.yongginae.store.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.attribute.standard.PrinterURI;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreCategoryRes {
    private String storeName;
    private String address;

    public StoreCategoryRes(Store store) {
        storeName = store.getStoreName();
        address = store.getAddress();
    }
}
