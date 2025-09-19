package com.mahesh.job_portal_app.repo;

import com.mahesh.job_portal_app.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {


    List<JobPost> jobPosts =  new ArrayList<>((Arrays.asList(
            new JobPost("Java Developer", "oracle", "mumbai", "Must have good experience in core Java and advanced Java"),
            new JobPost("Frontend Developer","Amazon", "Hyderabad", "Experience in building responsive web applications using React"),
            new JobPost("Data Scientist", "Cognizant", "Chennai","Strong background in machine learning and data analysis"),
            new JobPost("Network Engineer", "IBM", "Delhi","Design and implement computer networks for efficient data communication"),
            new JobPost("Mobile App Developer", "Verizon", "pune","Experience in mobile app development for iOS and Android")
    )));

    public void addJob(JobPost jobPost)
    {
        jobPosts.add(jobPost);
    }
    public List<JobPost> findAllJobs()
    {
        return jobPosts;
    }
}
