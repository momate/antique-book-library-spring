package com.momate.antiquebooklibraryspring.dao;

import com.momate.antiquebooklibraryspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Long, User> {
}
