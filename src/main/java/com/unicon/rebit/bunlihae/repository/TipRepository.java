package com.unicon.rebit.bunlihae.repository;

import com.unicon.rebit.bunlihae.domain.Tip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipRepository extends JpaRepository<Tip, Long> {

    List<Tip> findByRegion(String region);
}
