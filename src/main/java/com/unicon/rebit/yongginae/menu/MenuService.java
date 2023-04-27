package com.unicon.rebit.yongginae.menu;

import com.unicon.rebit.yongginae.menu.dto.MenuRes;
import com.unicon.rebit.yongginae.review.ReviewSearchRes;
import com.unicon.rebit.yongginae.store.Store;
import com.unicon.rebit.yongginae.store.StoreRepository;
import com.unicon.rebit.yongginae.store.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuRes findOne(Long store_id) {
        Menu menu = menuRepository.findOne(store_id);
        return new MenuRes(menu.getMenuList());

    }
}
