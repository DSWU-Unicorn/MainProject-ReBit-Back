package com.unicon.rebit.yongginae.userComment.dto;

import com.unicon.rebit.yongginae.review.Review;
import com.unicon.rebit.yongginae.user.User;
import com.unicon.rebit.yongginae.userComment.UserComment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCommentRes {
    private Long id; // comment_id
//    private Review review;
    private int star;
    private LocalDateTime commentDate;
    private String photo;
    private String commentDetail;

    public UserCommentRes(UserComment userComment) {
        id = userComment.getId();
        star = userComment.getStar();
        commentDate = userComment.getCommentDate();
        photo = userComment.getPhoto();
        commentDetail = userComment.getCommentDetail();
    }
}
