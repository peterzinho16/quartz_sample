package com.helixz.quartz.demo.service;

import com.helixz.quartz.demo.enitiy.CronSchedulerJob;

import java.util.List;

public interface CronSchedulerJobService {

    List<CronSchedulerJob> findAll();
}
