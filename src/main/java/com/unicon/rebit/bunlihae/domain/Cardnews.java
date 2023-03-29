package com.unicon.rebit.bunlihae.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cardnews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardnews_id")
    private Long id;

    private String image_src;

    private Date date;
}
