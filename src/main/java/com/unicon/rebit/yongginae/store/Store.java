package com.unicon.rebit.yongginae.store;

import com.unicon.rebit.yongginae.menu.Menu;
import com.unicon.rebit.yongginae.review.Review;
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
@Table(name = "store")
public class Store {
    @Id @GeneratedValue
    @Column (name = "store_id")
    private Long id;

    private String storeName;

    private String address;

    private String category1;

    private String category2;

    private String tel;

    private String store_photo;

    private double starAvg;

    private int reviewNum;

    @OneToMany(mappedBy = "store")
    private List<Review> review = new ArrayList<>();

    @OneToOne(mappedBy = "store", fetch = FetchType.LAZY)
    private Menu menu;

    @OneToMany(mappedBy = "store")
    private List<UserComment> userComments = new ArrayList<>();

}
