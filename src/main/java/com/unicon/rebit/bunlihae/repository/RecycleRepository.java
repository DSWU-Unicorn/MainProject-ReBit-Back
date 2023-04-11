package com.unicon.rebit.bunlihae.repository;

import com.unicon.rebit.bunlihae.domain.Recycle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecycleRepository extends JpaRepository<Recycle, Long> {
    Optional<Recycle> findByDataLabel(String label);

}
