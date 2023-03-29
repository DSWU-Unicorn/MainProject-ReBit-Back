package com.unicon.rebit.bunlihae.repository;

import com.unicon.rebit.bunlihae.domain.Cardnews;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface CardnewsRepository extends JpaRepository<Cardnews, Long> {

    List<Cardnews> getCardnewsByDate(Date date);
}
