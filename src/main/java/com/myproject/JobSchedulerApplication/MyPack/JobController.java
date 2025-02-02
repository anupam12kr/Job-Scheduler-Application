package com.myproject.JobSchedulerApplication.MyPack;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"api/jobs"})
public class JobController {
    @Autowired
    private JobService jobService;

    public JobController() {
    }

    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return this.jobService.createJob(job);
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return this.jobService.getAllJobs();
    }

    @GetMapping({"/{id}"})
    public Job getJobById(@PathVariable Long id) {
        return this.jobService.getJobById(id);
    }

    @PutMapping({"/{id}"})
    public Job updateJob(@PathVariable Long id, @RequestBody Job job) {
        return this.jobService.updateJob(id, job);
    }

    @DeleteMapping({"/{id}"})
    public void deleteJob(@PathVariable Long id) {
        this.jobService.deleteJob(id);
    }
}
