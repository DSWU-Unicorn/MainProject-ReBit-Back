package com.unicon.rebit.yongginae.store;

import com.unicon.rebit.yongginae.store.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
//    private final Store store;

    public StoreRes findOne(Long storeId) {
        Store store = storeRepository.findOne(storeId);
        return new StoreRes(store.getStoreName(), store.getCategory1(), store.getCategory2(), store.getAddress(), store.getTel());
    }

    public List<StoreCategoryRes> findCategory(String category1, String category2) {
        List<Store> stores = storeRepository.findAddress(category1, category2);
        return stores.stream().map(StoreCategoryRes::new).collect(Collectors.toList());
    }

    public StoreAddressRes findAddress (Long storeId) {
        Store store = storeRepository.findOne(storeId);
        return new StoreAddressRes(store.getAddress());
    }

    public List<StoreAroundAddressRes> findAroundAddress(String search) {
        List<Store> stores = storeRepository.findAroundAddress(search);
        return stores.stream().map(StoreAroundAddressRes::new).collect(Collectors.toList());
    }

    public List<StoreSearchRes> findStore(String storeName) {
        List<Store> stores = storeRepository.findStore(storeName);
        return stores.stream().map(StoreSearchRes::new).collect(Collectors.toList());
    }

}
