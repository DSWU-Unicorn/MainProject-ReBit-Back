package com.unicon.rebit.yongginae.user;

import com.unicon.rebit.yongginae.user.dto.UserRes;
import com.unicon.rebit.yongginae.userComment.UserComment;
import com.unicon.rebit.yongginae.userComment.UserCommentRepository;
import com.unicon.rebit.yongginae.userComment.dto.UserCommentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    // 코멘트 아이디 입력하면 댓글 내용 가져오기 - 진행 중
    /*
    public List<UserRes> findComment(Long id) {
        List<User> users = userRepository.findByUserComments_id(id);
        return users.stream().map(UserRes::new).collect(Collectors.toList());
    }
     */

}
