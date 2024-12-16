package com.hexaware.CareerCrafterApplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SkillDTO {
    @NotBlank(message = "Skill name cannot be blank")
    @Size(max = 100, message = "Skill name cannot exceed 100 characters")
    private String skillName;

    public SkillDTO() {
    }

    public SkillDTO(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public String toString() {
        return "SkillDTO{" +
                "skillName='" + skillName + '\'' +
                '}';
    }
}
