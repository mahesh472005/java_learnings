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

    public void addjob(JobPost jobPost)
    {
        jobRepo.addJob(jobPost);
    }
    public List<JobPost> findAllJobs()
    {

        return jobRepo.findAllJobs();
    }
}
