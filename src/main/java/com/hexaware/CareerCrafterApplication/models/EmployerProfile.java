package com.hexaware.CareerCrafterApplication.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class EmployerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employerId;
    
    private String username;
    
    private String email;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "employerProfile", cascade = CascadeType.ALL)
    private List<JobPosting> jobPostings = new ArrayList<>();

	public EmployerProfile() {
		super();
	}
	
	
	

	public EmployerProfile(Long employerId, String username, String email, Company company,
			List<JobPosting> jobPostings) {
		super();
		this.employerId = employerId;
		this.username = username;
		this.email = email;
		this.company = company;
		this.jobPostings = jobPostings;
	}


	

	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public Long getEmployerId() {
		return employerId;
	}

	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<JobPosting> getJobPostings() {
		return jobPostings;
	}

	public void setJobPostings(List<JobPosting> jobPostings) {
		this.jobPostings = jobPostings;
	}




	@Override
	public String toString() {
		return "EmployerProfile [employerId=" + employerId + ", username=" + username + ", email=" + email
				+ ", company=" + company + ", jobPostings=" + jobPostings + "]";
	}


	

	

    // Getters, Setters, Constructors
    
}

