package com.unicon.rebit.yongginae.user.dto;

import com.unicon.rebit.yongginae.user.User;
import com.unicon.rebit.yongginae.userComment.UserComment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRes {
    // 코멘트 아이디 입력하면 댓글 내용 가져오기 - 진행 중
    private Long user_id; // user_id
//    private Review review;
    private int star;
    private LocalDateTime commentDate;
    private String photo;
    private String commentDetail;

    public UserRes(User user) {
        user_id = user.getId();
    }

}
