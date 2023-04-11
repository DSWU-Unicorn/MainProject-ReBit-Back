package com.unicon.rebit.yongginae.review;

import com.unicon.rebit.yongginae.store.Store;
import com.unicon.rebit.yongginae.userComment.UserComment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    private int starAvg;

    private int reviewNum;

    private String photo;

    @OneToMany(mappedBy = "review")
    private List<UserComment> userComments = new ArrayList<>();

}