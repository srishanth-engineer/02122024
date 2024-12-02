package com.projectInfy.Emergency.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String profession;
    private String mentalStatus;
    private String eContacts;  // Assuming contacts are stored as a string (you can modify this if needed)

    public ProfileDTO(int id, String name) {
        this.id=id;
        this.name=name;
    }
}
