package com.myproject.JobSchedulerApplication.MyPack;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public JobService() {
    }

    public Job createJob(Job job) {
        job.setStatus("SCHEDULED");
        return (Job)this.jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return this.jobRepository.findAll();
    }

    public Job getJobById(Long id) {
        return (Job)this.jobRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Job not found with ID: " + id);
        });
    }

    public Job updateJob(Long id, Job updatedJob) {
        Job existingJob = this.getJobById(id);
        existingJob.setName(updatedJob.getName());
        existingJob.setScheduleTime(updatedJob.getScheduleTime());
        existingJob.setLastRunTime(updatedJob.getLastRunTime());
        existingJob.setRecurrence(updatedJob.getRecurrence());
        existingJob.setDescription(updatedJob.getDescription());
        existingJob.setStatus(updatedJob.getStatus());
        return (Job)this.jobRepository.save(existingJob);
    }

    public void deleteJob(Long id) {
        this.jobRepository.deleteById(id);
    }

    public List<Job> getScheduledJobs() {
        return this.jobRepository.findByStatus("SCHEDULED");
    }
}
