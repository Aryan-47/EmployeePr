package com.hexaware.CareerCrafterApplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EducationDTO {

    @NotBlank(message = "Degree cannot be blank")
    @Size(max = 100, message = "Degree cannot exceed 100 characters")
    private String degree;

    @NotBlank(message = "Institution name cannot be blank")
    @Size(max = 150, message = "Institution name cannot exceed 150 characters")
    private String institution;

    @NotBlank(message = "Grade cannot be blank")
    private String grade;

    @NotBlank(message = "Year of passing cannot be blank")
    private String yearOfPassing;

    public EducationDTO() {
    }

    public EducationDTO(String degree, String institution, String grade, String yearOfPassing) {
        this.degree = degree;
        this.institution = institution;
        this.grade = grade;
        this.yearOfPassing = yearOfPassing;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getYearOfPassing() {
        return yearOfPassing;
    }

    public void setYearOfPassing(String yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    @Override
    public String toString() {
        return "EducationDTO{" +
                "degree='" + degree + '\'' +
                ", institution='" + institution + '\'' +
                ", grade='" + grade + '\'' +
                ", yearOfPassing='" + yearOfPassing + '\'' +
                '}';
    }
}
