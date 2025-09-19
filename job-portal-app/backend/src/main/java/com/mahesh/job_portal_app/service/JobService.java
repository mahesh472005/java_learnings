package com.mahesh.job_portal_app.service;

import com.mahesh.job_portal_app.model.JobPost;
import com.mahesh.job_portal_app.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public void addJob(JobPost jobPost)
    {
        jobRepo.save(jobPost);
    }
    public List<JobPost> findAllJobs()
    {
        return jobRepo.findAll();
    }

    public JobPost getJob(int id) {
        return jobRepo.findById(id).orElse(new JobPost());
    }

    public JobPost updateJob(JobPost jobPost) {
        return jobRepo.save(jobPost);
    }

    public String deleteJob(int id) {
         jobRepo.deleteById(id);
         return "successfully deleted !";
    }
}
