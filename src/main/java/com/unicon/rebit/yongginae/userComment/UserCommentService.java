package com.unicon.rebit.yongginae.userComment;

import com.unicon.rebit.yongginae.store.Store;
import com.unicon.rebit.yongginae.store.StoreRepository;
import com.unicon.rebit.yongginae.store.dto.StoreCategoryRes;
import com.unicon.rebit.yongginae.user.User;
import com.unicon.rebit.yongginae.user.UserRepository;
import com.unicon.rebit.yongginae.userComment.dto.UserCommentReq;
import com.unicon.rebit.yongginae.userComment.dto.UserCommentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserCommentService {

    private final UserCommentRepository userCommentRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    public List<UserCommentRes> findUserComment(Long id) {
        List<UserComment> userComments = userCommentRepository.findByUser_id(id);
        return userComments.stream().map(UserCommentRes::new).collect(Collectors.toList());
    }

    @Transactional
    public Long addComment(UserCommentReq userCommentReq) {
        Store store = storeRepository.findOne(userCommentReq.getStoreId());

        User user = userRepository.findById(userCommentReq.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id"));

        UserComment userComment = new UserComment();

        userComment.setUser(user);
        userComment.setStore(store);

        userComment.setStar(userCommentReq.getStar());
        userComment.setCommentDate(LocalDateTime.now());
        userComment.setPhoto(userCommentReq.getPhoto());
        userComment.setCommentDetail(userCommentReq.getCommentDetail());

        userCommentRepository.save(userComment);
        return userComment.getId();
    }
}
