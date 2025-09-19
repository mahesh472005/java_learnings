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
            new JobPost(101,"Java Developer", "oracle", "mumbai", "Must have good experience in core Java and advanced Java"),
            new JobPost(102,"Frontend Developer","Amazon", "Hyderabad", "Experience in building responsive web applications using React"),
            new JobPost(103,"Data Scientist", "Cognizant", "Chennai","Strong background in machine learning and data analysis"),
            new JobPost(104,"Network Engineer", "IBM", "Delhi","Design and implement computer networks for efficient data communication"),
            new JobPost(105,"Mobile App Developer", "Verizon", "pune","Experience in mobile app development for iOS and Android")
    )));

    public void addJob(JobPost jobPost)
    {
        jobPosts.add(jobPost);
    }

    public List<JobPost> findAllJobs()
    {
        return jobPosts;
    }

    public JobPost getJob(int id) {
        for(JobPost job : jobPosts)
        {
            if(job.getId() == id)
            {
                return job;
            }
        }
        return null;
    }

    public JobPost updateJob(JobPost jobPost) {
        for(JobPost job : jobPosts)
        {
            if(job.getId() == jobPost.getId())
            {
                job.setId(jobPost.getId());
                job.setTitle(jobPost.getTitle());
                job.setCompany(jobPost.getCompany());
                job.setLocation(jobPost.getLocation());
                job.setDesc(jobPost.getDesc());
                return job;
            }
        }
        return null;
    }

    public String deleteJob(int id) {
        for(JobPost job : jobPosts)
        {
            if(job.getId() == id)
            {
                jobPosts.remove(job);
                return "Successfully Deleted !";
            }
        }
        return "Failed to delete";
    }
}
