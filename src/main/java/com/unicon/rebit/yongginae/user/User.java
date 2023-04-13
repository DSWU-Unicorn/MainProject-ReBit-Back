package com.unicon.rebit.yongginae.user;

import com.unicon.rebit.yongginae.review.Review;
import com.unicon.rebit.yongginae.userComment.UserComment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

//    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
//    private UserComment userComment;

    @OneToMany(mappedBy = "user")
    private List<UserComment> userComments = new ArrayList<>();

    @ColumnDefault("0")
    private int point;

    public void postPoint(int point) {
        this.point += point;
    }

}
