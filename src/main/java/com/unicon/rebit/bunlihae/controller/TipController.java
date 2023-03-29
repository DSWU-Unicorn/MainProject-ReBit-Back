package com.unicon.rebit.bunlihae.controller;

import com.unicon.rebit.bunlihae.domain.Tip;
import com.unicon.rebit.bunlihae.service.TipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TipController {

    private final TipService tipService;

    @GetMapping("/tip/{region}")
    public List<Tip> getTipByRegion(@PathVariable(name = "region") String region) {
        return tipService.getTipByRegion(region);
    }
}
