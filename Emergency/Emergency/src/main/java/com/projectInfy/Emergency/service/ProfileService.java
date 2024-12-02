package com.projectInfy.Emergency.service;

import com.projectInfy.Emergency.model.Profile;
import com.projectInfy.Emergency.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ProfileRepo profileRepo;

    // Fetching user profile by ID and returning all necessary details
    public Profile getUserById(Long id) {
        return profileRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found for id: " + id));
    }

    // Updating mental status based on the score provided
    public void updateMentalStatus(Long id, int score) {
        Profile profile = profileRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found for id: " + id));

        // Determine the mental status based on the score
        String mentalStatus;
        if (score > 120) {
            mentalStatus = "Perfect";
        } else if (score >= 90) {
            mentalStatus = "Good";
        } else {
            mentalStatus = "Bad";
        }

        // Update the mental status in the profile
        profile.setMentalStatus(mentalStatus);

        // Save the updated profile
        profileRepo.save(profile);
    }
}
