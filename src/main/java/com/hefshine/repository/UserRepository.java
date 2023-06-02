package com.hefshine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hefshine.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	int countByName(String name);
}
