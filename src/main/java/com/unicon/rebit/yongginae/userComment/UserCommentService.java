package com.unicon.rebit.yongginae.userComment;

import com.unicon.rebit.yongginae.store.Store;
import com.unicon.rebit.yongginae.store.StoreRepository;
import com.unicon.rebit.yongginae.store.dto.StoreCategoryRes;
import com.unicon.rebit.yongginae.userComment.dto.UserCommentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserCommentService {

    private final UserCommentRepository userCommentRepository;

    public List<UserCommentRes> findUserComment(Long id) {
        List<UserComment> userComments = userCommentRepository.findByUser_id(id);
        return userComments.stream().map(UserCommentRes::new).collect(Collectors.toList());
    }

}
