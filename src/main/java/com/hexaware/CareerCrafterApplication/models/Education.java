package com.hexaware.CareerCrafterApplication.models;

import jakarta.persistence.*;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String degree;
    private String institution;
    private String grade; // Grade or percentage achieved
    private String yearOfPassing; // Year of passing the degree

    @ManyToOne
    @JoinColumn(name = "job_seeker_profile_id", nullable = false)
    private JobSeekerProfile jobSeekerProfile;

    public Education() {
    }
    

    public Education(Long id, String degree, String institution, String grade, String yearOfPassing,
			JobSeekerProfile jobSeekerProfile) {
		super();
		this.id = id;
		this.degree = degree;
		this.institution = institution;
		this.grade = grade;
		this.yearOfPassing = yearOfPassing;
		this.jobSeekerProfile = jobSeekerProfile;
	}


	public Education(Long id, String degree, String institution, String grade, String yearOfPassing) {
		super();
		this.id = id;
		this.degree = degree;
		this.institution = institution;
		this.grade = grade;
		this.yearOfPassing = yearOfPassing;
	}


	public Education(String degree, String institution, String grade, String yearOfPassing) {
		super();
		this.degree = degree;
		this.institution = institution;
		this.grade = grade;
		this.yearOfPassing = yearOfPassing;
	}


	public Education(String degree, String institution, String grade, String yearOfPassing, JobSeekerProfile jobSeekerProfile) {
        this.degree = degree;
        this.institution = institution;
        this.grade = grade;
        this.yearOfPassing = yearOfPassing;
        this.jobSeekerProfile = jobSeekerProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public JobSeekerProfile getJobSeekerProfile() {
        return jobSeekerProfile;
    }

    public void setJobSeekerProfile(JobSeekerProfile jobSeekerProfile) {
        this.jobSeekerProfile = jobSeekerProfile;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", degree='" + degree + '\'' +
                ", institution='" + institution + '\'' +
                ", grade='" + grade + '\'' +
                ", yearOfPassing='" + yearOfPassing + '\'' +
                ", jobSeekerProfile=" + (jobSeekerProfile != null ? jobSeekerProfile.getProfileId() : null) +
                '}';
    }
}
