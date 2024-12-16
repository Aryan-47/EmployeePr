package com.hexaware.CareerCrafterApplication.dto;

public class ResumeDTO {
    private String resumeURL; // URL for the uploaded resume
    private String resumeFileName; // Name of the uploaded resume file

    public ResumeDTO() {
    }

    public ResumeDTO(String resumeURL, String resumeFileName) {
        this.resumeURL = resumeURL;
        this.resumeFileName = resumeFileName;
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

    @Override
    public String toString() {
        return "ResumeDTO{" +
                "resumeURL='" + resumeURL + '\'' +
                ", resumeFileName='" + resumeFileName + '\'' +
                '}';
    }
}
