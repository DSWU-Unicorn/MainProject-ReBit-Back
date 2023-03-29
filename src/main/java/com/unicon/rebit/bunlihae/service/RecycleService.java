package com.unicon.rebit.bunlihae.service;

import com.unicon.rebit.bunlihae.domain.Recycle;
import com.unicon.rebit.bunlihae.repository.RecycleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecycleService {

    private final RecycleRepository recycleRepository;


    public List<Recycle> getRecycleByDataLabel(String label) {
        List<Recycle> byDataLabel = recycleRepository.findByDataLabel(label);
        return byDataLabel;
    }
}
