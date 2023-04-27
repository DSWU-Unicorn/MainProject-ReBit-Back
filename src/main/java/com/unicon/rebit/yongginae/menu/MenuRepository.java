package com.unicon.rebit.yongginae.menu;

import com.unicon.rebit.yongginae.store.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MenuRepository {
    private final EntityManager em;

    public Menu findOne(Long id) {
        return em.find(Menu.class, id);
    }
}
