package com.unicon.rebit.yongginae.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StoreReviewsRes {
    private Long user_id;
    private int star;
    private LocalDateTime commentDate;
    private String photo;
    private String commentDetail;
}
