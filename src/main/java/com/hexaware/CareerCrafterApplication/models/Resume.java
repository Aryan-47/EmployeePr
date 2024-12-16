package com.hexaware.CareerCrafterApplication.models;

import jakarta.persistence.*;

@Entity
@Table(name = "resumes")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the resume

    @Column(name = "resume_url", nullable = false)
    private String resumeURL; // URL for the uploaded resume

    @Column(name = "resume_file_name", nullable = false)
    private String resumeFileName; // Name of the uploaded resume file

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_seeker_id", nullable = false)
    private JobSeekerProfile jobSeekerProfile; // Many resumes can belong to one job seeker

    public Resume() {
    }
    
    

    public Resume(Long id, String resumeURL, String resumeFileName, JobSeekerProfile jobSeekerProfile) {
		super();
		this.id = id;
		this.resumeURL = resumeURL;
		this.resumeFileName = resumeFileName;
		this.jobSeekerProfile = jobSeekerProfile;
	}
    


	public Resume(Long id, String resumeURL, String resumeFileName) {
		super();
		this.id = id;
		this.resumeURL = resumeURL;
		this.resumeFileName = resumeFileName;
	}



	public Resume(String resumeURL, String resumeFileName) {
		super();
		this.resumeURL = resumeURL;
		this.resumeFileName = resumeFileName;
	}



	public Resume(String resumeURL, String resumeFileName, JobSeekerProfile jobSeekerProfile) {
        this.resumeURL = resumeURL;
        this.resumeFileName = resumeFileName;
        this.jobSeekerProfile = jobSeekerProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResumeURL() {
        return resumeURL;
    }

    public void setResumeURL(String resumeURL) {
        this.resumeURL = resumeURL;
    }

    public String getResumeFileName() {
        return resumeFileName;
    }

    public void setResumeFileName(String resumeFileName) {
        this.resumeFileName = resumeFileName;
    }

    public JobSeekerProfile getJobSeekerProfile() {
        return jobSeekerProfile;
    }

    public void setJobSeekerProfile(JobSeekerProfile jobSeekerProfile) {
        this.jobSeekerProfile = jobSeekerProfile;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", resumeURL='" + resumeURL + '\'' +
                ", resumeFileName='" + resumeFileName + '\'' +
                '}';
    }
}
