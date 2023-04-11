package com.unicon.rebit.yongginae.store.dto;

import com.unicon.rebit.yongginae.store.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreAddressRes {
    private String address;

    public StoreAddressRes(Store store) {
        address = store.getAddress();
    }
}
