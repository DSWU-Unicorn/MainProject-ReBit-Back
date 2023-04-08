package com.unicon.rebit.bunlihae.service;

import com.unicon.rebit.bunlihae.domain.User;
import com.unicon.rebit.bunlihae.repository.UserRepository;
//import com.unicon.rebit.response.exception.CustomException;
//import com.unicon.rebit.response.exception.CustomExceptionStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

}
