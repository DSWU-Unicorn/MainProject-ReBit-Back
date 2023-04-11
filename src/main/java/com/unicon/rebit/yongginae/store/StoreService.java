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



}
