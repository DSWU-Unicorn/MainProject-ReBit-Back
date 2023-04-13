package com.unicon.rebit.bunlihae.controller;

import com.unicon.rebit.bunlihae.domain.Tip;
import com.unicon.rebit.bunlihae.service.TipService;
import com.unicon.rebit.yongginae.configure.response.CommonResponse;
import com.unicon.rebit.yongginae.configure.response.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class TipController {


    private final TipService tipService;
    private final ResponseService responseService;

    @GetMapping("/tip")
    public CommonResponse getTipByRegion() {
        List<Tip> list = tipService.getTipByRegion();
        return responseService.getDataResponse(list);
    }

    @PostMapping("/tip/{id}")
    public CommonResponse postUserWithPoint(@PathVariable(value = "id") Long id) {
        int point = tipService.postUserWithPoint(id);
        return responseService.getDataResponse(point);
    }


}
