package com.unicon.rebit.yongginae.user;

import com.unicon.rebit.yongginae.userComment.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    // comment_id로 정보들 가져오기
    // 코멘트 아이디 입력하면 댓글 내용 가져오기 - 진행 중
    /*
    List<User> findByUserComments_id(Long id);
     */

}
