package com.unicon.rebit.bunlihae.repository;


import com.unicon.rebit.bunlihae.domain.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepository extends JpaRepository<Guide, Long> {
    Guide findByRegion(String region);
}
