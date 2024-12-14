package com.artipo.artipo.repository;

import com.artipo.artipo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {}
