package com.helixz.quartz.demo.service.impl;

import com.helixz.quartz.demo.enitiy.CronSchedulerJob;
import com.helixz.quartz.demo.repository.CronSchedulerJobRepository;
import com.helixz.quartz.demo.service.CronSchedulerJobService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CronSchedulerJobServiceImpl implements CronSchedulerJobService {

    private CronSchedulerJobRepository cronSchedulerJobRepository;

    public CronSchedulerJobServiceImpl(CronSchedulerJobRepository cronSchedulerJobRepository){
        this.cronSchedulerJobRepository = cronSchedulerJobRepository;
    }

    @Override
    public List<CronSchedulerJob> findAll() {
        return (List<CronSchedulerJob>) cronSchedulerJobRepository.findAll();
    }
}
