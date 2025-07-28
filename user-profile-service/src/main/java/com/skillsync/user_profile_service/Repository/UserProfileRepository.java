package com.skillsync.user_profile_service.Repository;

import com.skillsync.user_profile_service.Entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, String> {
}
