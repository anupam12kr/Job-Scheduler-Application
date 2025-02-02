package com.myproject.JobSchedulerApplication.MyPack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class JobSchedulerService {
    @Autowired
    private JobExecutionService jobExecutionService;

    public JobSchedulerService() {
    }

    @Scheduled(
            fixedRate = 6000L
    )
    public void checkAndExecuteJobs() {
        System.out.println("Checking for scheduled jobs...");
        this.jobExecutionService.executeJobs();
    }
}
