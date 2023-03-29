package com.unicon.rebit.bunlihae.controller;

import com.unicon.rebit.bunlihae.domain.Cardnews;
import com.unicon.rebit.bunlihae.repository.CardnewsRepository;
import com.unicon.rebit.bunlihae.service.CardnewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardnewsController {

    private final CardnewsService cardnewsService;
    private final CardnewsRepository cardnewsRepository;

    @GetMapping("/cardnews/{date}")
    public List<Cardnews> getCardnews(@PathVariable(value = "date") String date) {
        return cardnewsService.getCardnews(date);
    }

}
