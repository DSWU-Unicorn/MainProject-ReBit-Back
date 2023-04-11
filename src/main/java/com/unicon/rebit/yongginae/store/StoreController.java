package com.unicon.rebit.yongginae.store;

import com.unicon.rebit.yongginae.configure.response.DataResponse;
import com.unicon.rebit.yongginae.configure.response.ResponseService;
import com.unicon.rebit.yongginae.store.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;
    private final ResponseService responseService;

    @GetMapping("/store/{store_id}")
    public DataResponse<StoreRes> getStoreInfo(@PathVariable("store_id") Long store_id) {
        StoreRes res = storeService.findOne(store_id);
        return responseService.getDataResponse(res);
    }

    @GetMapping("/store/{category1}/{category2}")
    public DataResponse<List<StoreCategoryRes>> getStoreAddressByCategory(@PathVariable("category1") String category1, @PathVariable("category2") String category2) {
        List<StoreCategoryRes> stores = storeService.findCategory(category1, category2);
        return responseService.getDataResponse(stores);
    }

    @GetMapping("/store/takeout/{store_id}")
    public DataResponse<StoreAddressRes> getStoreAddress(@PathVariable("store_id") Long store_id) {
        StoreAddressRes res = storeService.findAddress(store_id);
        return responseService.getDataResponse(res);
    }

    // 마크용 주소 검색
    @GetMapping("/store/mark/{search}")
    public DataResponse<List<StoreAroundAddressRes>> getStoreAroundAddress(@PathVariable("search") String search) {
        List<StoreAroundAddressRes> stores = storeService.findAroundAddress(search);
        return responseService.getDataResponse(stores);
    }

}
