package com.mahesh.job_portal_app.controller;

import com.mahesh.job_portal_app.model.JobPost;
import com.mahesh.job_portal_app.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping({"/","home"})
    public String home()
    {
        return "home";
    }

    @GetMapping("addjob")
    public String addJob()
    {
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost)
    {
        jobService.addjob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewAllJobs(Model model)
    {
        List<JobPost> jobs = jobService.findAllJobs();
        model.addAttribute("jobs", jobs);
        return "viewalljobs";
    }
}
