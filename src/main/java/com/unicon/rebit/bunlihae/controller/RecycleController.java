package com.unicon.rebit.bunlihae.controller;

import com.unicon.rebit.bunlihae.domain.Recycle;
import com.unicon.rebit.bunlihae.repository.RecycleRepository;
import com.unicon.rebit.bunlihae.service.RecycleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecycleController {

    private final RecycleService recycleService;

    @GetMapping("/recycle/{data-label}")
    public List<Recycle> getRecycleByDataLabel(@PathVariable(name = "data-label") String label) {
        return recycleService.getRecycleByDataLabel(label);
    }

}
