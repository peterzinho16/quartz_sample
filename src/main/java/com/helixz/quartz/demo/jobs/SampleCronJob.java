package com.helixz.quartz.demo.jobs;

import com.helixz.quartz.demo.repository.SchedulerRepository;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalTime;
import java.util.Date;

@Slf4j
@DisallowConcurrentExecution
public class SampleCronJob extends QuartzJobBean {

    @Autowired
    private SchedulerRepository schedulerRepository;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        LocalTime localTime = LocalTime.now();
        Integer hourInSeconds = localTime.getHour() * 3600 + localTime.getMinute() * 60 + localTime.getSecond();
        schedulerRepository.updateSellers(hourInSeconds);
    }
}
