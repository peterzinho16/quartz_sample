package com.helixz.quartz.demo.repository;

import com.helixz.quartz.demo.enitiy.CronSchedulerJob;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CronSchedulerJobRepository extends CrudRepository<CronSchedulerJob, UUID> {
}
