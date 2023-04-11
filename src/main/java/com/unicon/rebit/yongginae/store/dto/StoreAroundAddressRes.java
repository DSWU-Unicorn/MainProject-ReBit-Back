package com.unicon.rebit.yongginae.store.dto;

import com.unicon.rebit.yongginae.store.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreAroundAddressRes {
    private String address;
    private Long id;

    public StoreAroundAddressRes(Store store) {
        address = store.getAddress();
        id = store.getId();
    }
}
