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

}
