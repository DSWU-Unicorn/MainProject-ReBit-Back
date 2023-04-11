package com.unicon.rebit.yongginae.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepository {
    private final EntityManager em;

    // 마커 클릭시 가게 정보 전달
    public Store findOne(Long id) {
        return em.find(Store.class, id);
    }
}
