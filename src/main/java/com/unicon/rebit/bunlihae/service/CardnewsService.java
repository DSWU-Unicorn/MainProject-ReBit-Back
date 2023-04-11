package com.unicon.rebit.bunlihae.service;

import com.unicon.rebit.bunlihae.domain.Cardnews;
import com.unicon.rebit.bunlihae.repository.CardnewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CardnewsService {

    private final CardnewsRepository cardnewsRepository;


    public List<Cardnews> getCardnews(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = new Date();

        try {
            parse = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return cardnewsRepository.getCardnewsByDate(parse);

    }
}
