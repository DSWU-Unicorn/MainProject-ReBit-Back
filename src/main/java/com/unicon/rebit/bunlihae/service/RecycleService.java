package com.unicon.rebit.bunlihae.service;

import com.unicon.rebit.bunlihae.domain.Guide;
import com.unicon.rebit.bunlihae.domain.Recycle;
import com.unicon.rebit.bunlihae.domain.User;
import com.unicon.rebit.bunlihae.repository.GuideRepository;
import com.unicon.rebit.bunlihae.repository.RecycleRepository;
import com.unicon.rebit.bunlihae.repository.UserRepository;
//import com.unicon.rebit.response.exception.CustomException;
//import com.unicon.rebit.response.exception.CustomExceptionStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecycleService {

    private final RecycleRepository recycleRepository;
    private final UserRepository userRepository;
    private final GuideRepository guideRepository;


    /*
    public Recycle getRecycleByDataLabel(String label) {
        Recycle recycle = recycleRepository.findByDataLabel(label)
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.RECYCLE_NOT_FOUND));
        System.out.println(">>>>>>>>>>>>>>>>>>" + recycle.getId());
        return recycle;
    }


    @Transactional
    public int postUserWithPoint(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.ACCOUNT_NOT_FOUND));
        user.postPoint(200);
        return user.getPoint();
    }

    public Guide getRecycleByRegion(String region) {
        Guide byRegion = guideRepository.findByRegion(region);
        return byRegion;
    }

     */
}
