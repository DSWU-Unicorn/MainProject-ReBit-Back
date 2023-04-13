package com.unicon.rebit.bunlihae.controller;

import com.unicon.rebit.bunlihae.domain.Guide;
import com.unicon.rebit.bunlihae.domain.Recycle;
import com.unicon.rebit.bunlihae.service.RecycleService;
import com.unicon.rebit.yongginae.configure.response.CommonResponse;
import com.unicon.rebit.yongginae.configure.response.DataResponse;
import com.unicon.rebit.yongginae.configure.response.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class RecycleController {


    private final RecycleService recycleService;
    private final ResponseService responseService;

    @GetMapping("/recycle/{data-label}")
    public CommonResponse getRecycleByDataLabel(@PathVariable(name = "data-label") String label) {
        Recycle recycle = recycleService.getRecycleByDataLabel(label);
        return responseService.getDataResponse(recycle);
    }

    @PostMapping("/recycle/{id}")
    public CommonResponse postUserWithPoint(@PathVariable(value = "id") Long id) {
        int point = recycleService.postUserWithPoint(id);
        return responseService.getDataResponse(point);
    }


    @GetMapping("/recycle/region/{region}")
    public DataResponse<Guide> getRecycleByRegion(@PathVariable(value = "region") String region) {
        Guide recycleByRegion = recycleService.getRecycleByRegion(region);
        return responseService.getDataResponse(recycleByRegion);
    }



}
