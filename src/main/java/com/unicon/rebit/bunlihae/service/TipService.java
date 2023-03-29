package com.unicon.rebit.bunlihae.service;

import com.unicon.rebit.bunlihae.domain.Tip;
import com.unicon.rebit.bunlihae.repository.TipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TipService {

    private final TipRepository tipRepository;

    public List<Tip> getTipByRegion(String region) {
        return tipRepository.findByRegion(region);
    }
}
