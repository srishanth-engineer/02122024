package com.projectInfy.Emergency.repository;

import com.projectInfy.Emergency.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile, Long> {
}
