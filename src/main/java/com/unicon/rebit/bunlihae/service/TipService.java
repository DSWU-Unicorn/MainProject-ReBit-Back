package com.unicon.rebit.bunlihae.service;

import com.unicon.rebit.bunlihae.domain.Tip;
import com.unicon.rebit.bunlihae.repository.TipRepository;
import com.unicon.rebit.yongginae.configure.response.exception.CustomException;
import com.unicon.rebit.yongginae.configure.response.exception.CustomExceptionStatus;
import com.unicon.rebit.yongginae.user.User;
import com.unicon.rebit.yongginae.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TipService {


    private final TipRepository tipRepository;
    private final UserRepository userRepository;


    /**
     * 수정 필요
     */
    public List<Tip> getTipByRegion( ) {
        return tipRepository.findAll();
    }



    @Transactional
    public int postUserWithPoint(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.ACCOUNT_NOT_FOUND));
        user.postPoint(100);
        return user.getPoint();
    }


}
