package com.myproject.JobSchedulerApplication.MyPack;

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobExecutionService {
    @Autowired
    private JobService jobService;
    private static final int MAX_RETRY_COUNT = 3;

    public JobExecutionService() {
    }

    public void executeJobs() {
        List<Job> scheduledJobs = this.jobService.getScheduledJobs();
        Iterator var2 = scheduledJobs.iterator();

        while(var2.hasNext()) {
            Job job = (Job)var2.next();
            if (job.getScheduleTime().isBefore(LocalDateTime.now())) {
                try {
                    System.out.println("Executing job: " + job.getName());
                    this.performJobTask(job);
                    this.performJobTaskWithRetry(job);
                    job.setStatus("COMPLETED");
                } catch (Exception var5) {
                    System.err.println("Failed to execute job: " + job.getName());
                    job.setStatus("FAILED");
                }

                job.setLastRunTime(LocalDateTime.now());
                this.jobService.updateJob(job.getId(), job);
            }
        }

    }

    private void performJobTask(Job job) throws Exception {
        System.out.println("Task executed for job: " + job.getName());
    }

    private void performJobTaskWithRetry(Job job) throws Exception {
        int retryCount = 0;

        while(retryCount < 3) {
            try {
                this.performJobTask(job);
                return;
            } catch (Exception var4) {
                ++retryCount;
                PrintStream var10000 = System.err;
                String var10001 = job.getName();
                var10000.println("Retrying job: " + var10001 + " (Attempt " + retryCount + ")");
            }
        }

        throw new Exception("Job failed after maximum retries: " + job.getName());
    }
}
