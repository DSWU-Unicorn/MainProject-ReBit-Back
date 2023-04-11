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

    public List<Store> findAddress(String category1, String category2) {
        return em.createQuery("select s from Store s where s.category1 = :category1 and s.category2 =:category2", Store.class)
                .setParameter("category1", category1)
                .setParameter("category2", category2)
                .getResultList();
    }

}
