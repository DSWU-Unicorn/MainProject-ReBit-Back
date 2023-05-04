package com.unicon.rebit.yongginae.store;

import com.unicon.rebit.yongginae.configure.response.CommonResponse;
import com.unicon.rebit.yongginae.configure.response.DataResponse;
import com.unicon.rebit.yongginae.configure.response.ResponseService;
import com.unicon.rebit.yongginae.store.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    // 마커용 주소 검색
    @GetMapping("/store/mark/{search}")
    public DataResponse<List<StoreAroundAddressRes>> getStoreAroundAddress(@PathVariable("search") String search) {
        List<StoreAroundAddressRes> stores = storeService.findAroundAddress(search);
        return responseService.getDataResponse(stores);
    }

    // 가게 검색
    @GetMapping("/store/search/{search}")
    public DataResponse<List<StoreSearchRes>> getStore (@PathVariable("search") String search) {
        List<StoreSearchRes> stores = storeService.findStore(search);
        return responseService.getDataResponse(stores);
    }

    // 가게 정보 반환 by store_id
    @GetMapping("/store/info/{store_id}")
    public DataResponse<StoreSearchRes> getStoreDetailInfo (@PathVariable("store_id") Long store_id) {
        StoreSearchRes res = storeService.findStoreDetail(store_id);
        return responseService.getDataResponse(res);
    }

    // 가게 검색2 - 반환 값 변경
    @GetMapping("/store/searchName/{search}")
    public DataResponse<List<StoreSearchNameRes>> getStoreName (@PathVariable("search") String search) {
        List<StoreSearchNameRes> stores = storeService.findStoreName(search);
        return responseService.getDataResponse(stores);
    }

    // 포장시 포인트 증가 로직
    @PostMapping("/store/takeout/{user_id}")
    public CommonResponse postUserWithPoint(@PathVariable(value = "user_id") Long user_id) {
        int point = storeService.postUserWithPoint(user_id);
        return responseService.getDataResponse(point);
    }

    // 리뷰 리스트 반환
    @GetMapping("/store/reviews/{store_id}")
    public DataResponse<List<StoreReviewsRes>> getReviews (@PathVariable("store_id") Long store_id) {
        List<StoreReviewsRes> stores = storeService.findReviews(store_id);
        return responseService.getDataResponse(stores);
    }

}
