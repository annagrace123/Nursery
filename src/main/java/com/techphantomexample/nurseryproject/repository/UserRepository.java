package com.techphantomexample.nurseryproject.repository;

import com.techphantomexample.nurseryproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository <User, Integer> {
}
