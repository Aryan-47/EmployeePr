package com.hexaware.CareerCrafterApplication.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.CareerCrafterApplication.customExceptions.ResourceNotFoundException;
import com.hexaware.CareerCrafterApplication.dto.RecommendedJobDTO;
import com.hexaware.CareerCrafterApplication.models.JobPosting;
import com.hexaware.CareerCrafterApplication.models.RecommendedJobs;
import com.hexaware.CareerCrafterApplication.repository.JobSeekerProfileRepository;
import com.hexaware.CareerCrafterApplication.repository.RecommendedJobsRepository;

@Service
public class RecommendationServiceImpl implements IRecommendationServiceI {

    @Autowired
    private RecommendedJobsRepository recommendedJobsRepository;

    @Autowired
    private JobSeekerProfileRepository jobSeekerProfileRepository;

    @Override
    public List<RecommendedJobDTO> getRecommendedJobsByJobSeekerId(Long jobSeekerId) throws ResourceNotFoundException {
        jobSeekerProfileRepository.findById(jobSeekerId)
            .orElseThrow(() -> new ResourceNotFoundException("JobSeekerProfile", "id", jobSeekerId));

        List<RecommendedJobs> recommendedJobs = recommendedJobsRepository.findByJobSeekerProfileId(jobSeekerId);

        return recommendedJobs.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private RecommendedJobDTO convertToDTO(RecommendedJobs recommendedJob) {
        JobPosting jobPosting = recommendedJob.getJobPosting();
        return new RecommendedJobDTO(
                recommendedJob.getRecommendedId(),
                jobPosting.getJobId(),
                jobPosting.getJobTitle(),
                jobPosting.getEmployerProfile().getCompany().getCompanyName(),
                jobPosting.getLocation().getCity(),
                jobPosting.getRequiredSkills(),
                recommendedJob.getReason()
        );
    }
}
