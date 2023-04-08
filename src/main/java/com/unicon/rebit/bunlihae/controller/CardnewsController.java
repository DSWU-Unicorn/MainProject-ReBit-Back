package com.unicon.rebit.bunlihae.controller;

import com.unicon.rebit.bunlihae.domain.Cardnews;
import com.unicon.rebit.bunlihae.service.CardnewsService;
//import com.unicon.rebit.response.CommonResponse;
//import com.unicon.rebit.response.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardnewsController {

    /*
    private final CardnewsService cardnewsService;
    private final ResponseService responseService;

    @GetMapping("/cardnews/{date}")
    public CommonResponse getCardnews(@PathVariable(value = "date") String date) {
        List<Cardnews> list = cardnewsService.getCardnews(date);
        return responseService.getDataResponse(list);
    }

     */


}
