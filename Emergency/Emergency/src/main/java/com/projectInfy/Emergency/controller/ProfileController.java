package com.projectInfy.Emergency.controller;

import com.projectInfy.Emergency.DTO.ProfileDTO;
import com.projectInfy.Emergency.model.Profile;
import com.projectInfy.Emergency.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow CORS for this controller
@RequestMapping("/") // General request mapping for profiles
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    // Endpoint to fetch a simple profile with basic info (id and name)
    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ProfileDTO getBasicProfileById(@PathVariable Long id) {
        Profile profile = profileService.getUserById(id);
        // Return only id and name
        return new ProfileDTO(profile.getId(), profile.getName());
    }

    // Endpoint to fetch the detailed profile information by ID
    @GetMapping("/{id}/profile")
    public ProfileDTO getDetailedProfileById(@PathVariable Long id) {
        Profile profile = profileService.getUserById(id);
        // Return detailed profile data
        return new ProfileDTO(profile.getId(), profile.getName(), profile.getAge(),
                profile.getGender(), profile.getProfession(),
                profile.getMentalStatus(), profile.getEContacts());
    }

    // Simple test endpoint (can be removed later)
    @GetMapping("/test")
    public String profiledetails() {
        return "Hello World from Profile Service!";
    }

    // New endpoint to update the mental status based on score
    @PostMapping("/{id}/mental-status")
    public String updateMentalStatus(@PathVariable Long id, @RequestParam int score) {
        profileService.updateMentalStatus(id, score);
        return "Mental status updated successfully!";
    }
}
