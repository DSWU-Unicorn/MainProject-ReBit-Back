package com.unicon.rebit.bunlihae.repository;

import com.unicon.rebit.bunlihae.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
