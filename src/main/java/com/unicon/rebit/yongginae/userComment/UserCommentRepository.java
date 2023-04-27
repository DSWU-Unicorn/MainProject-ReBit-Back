package com.unicon.rebit.yongginae.userComment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserCommentRepository extends JpaRepository<UserComment, Long> {
    // user_id로 userComment 값 가져오기
    List<UserComment> findByUser_id(Long id);


}


