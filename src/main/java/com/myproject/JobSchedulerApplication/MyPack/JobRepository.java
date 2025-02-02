package com.myproject.JobSchedulerApplication.MyPack;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByStatus(String status);
}
