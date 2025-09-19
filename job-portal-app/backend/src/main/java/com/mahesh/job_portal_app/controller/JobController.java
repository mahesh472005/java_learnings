package com.mahesh.job_portal_app.controller;

import com.mahesh.job_portal_app.model.JobPost;
import com.mahesh.job_portal_app.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173/")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("jobs")
    @ResponseBody
    public List<JobPost> getJobs()
    {
        return jobService.findAllJobs();
    }

    @GetMapping("job/{id}")
    public JobPost getJob(@PathVariable("id") int id)
    {
        return jobService.getJob(id);
    }

    @PostMapping("job")
    public String addJob(@RequestBody JobPost jobPost)
    {
        jobService.addjob(jobPost);
        return "Successfully added \n" + jobPost;
    }

    @PutMapping("job")
    public JobPost updateJob(@RequestBody JobPost jobPost)
    {
        return jobService.updateJob(jobPost);
    }

    @DeleteMapping("job/{id}")
    public String deleteJob(@PathVariable("id") int id)
    {
        return jobService.deleteJob(id);
    }


}
