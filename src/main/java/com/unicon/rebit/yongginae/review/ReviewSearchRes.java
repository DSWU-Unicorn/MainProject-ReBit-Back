package com.unicon.rebit.yongginae.review;

import com.unicon.rebit.yongginae.store.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewSearchRes {
    private int starAvg;
    private int reviewNum;

    public ReviewSearchRes(Review review) {
        starAvg = review.getStarAvg();
        reviewNum = review.getReviewNum();
    }
}