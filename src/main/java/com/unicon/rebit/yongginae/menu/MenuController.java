package com.unicon.rebit.yongginae.menu;

import com.unicon.rebit.yongginae.configure.response.DataResponse;
import com.unicon.rebit.yongginae.configure.response.ResponseService;
import com.unicon.rebit.yongginae.menu.dto.MenuRes;
import com.unicon.rebit.yongginae.store.StoreService;
import com.unicon.rebit.yongginae.store.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;
    private final ResponseService responseService;

    @GetMapping("/menu/{store_id}")
    public DataResponse<MenuRes> getMenu(@PathVariable("store_id") Long store_id) {
        MenuRes res = menuService.findOne(store_id);
        return responseService.getDataResponse(res);
    }
}
