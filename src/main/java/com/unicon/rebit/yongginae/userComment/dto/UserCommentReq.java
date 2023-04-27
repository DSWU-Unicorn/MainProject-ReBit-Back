package com.unicon.rebit.yongginae.userComment.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCommentReq {
    private Long storeId;
    private Long userId;
    private int star;
    private String photo;
    private String commentDetail;
}
