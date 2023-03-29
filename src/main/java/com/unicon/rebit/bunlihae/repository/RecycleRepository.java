package com.unicon.rebit.bunlihae.repository;

import com.unicon.rebit.bunlihae.domain.Recycle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecycleRepository extends JpaRepository<Recycle, Long> {
    List<Recycle> findByDataLabel(String label);

}
