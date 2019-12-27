package com.helixz.quartz.demo.component;

import com.helixz.quartz.demo.enitiy.SchedulerJobInfo;
import com.helixz.quartz.demo.repository.SchedulerJobInfoRepository;
import com.helixz.quartz.demo.service.SchedulerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author Chamith
 */
@Slf4j
@Component
public class SchedulerStartUpHandler implements ApplicationRunner {

    @Autowired
    private SchedulerService schedulerService;

    @Autowired
    private SchedulerJobInfoRepository schedulerJobInfoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Schedule all new scheduler jobs at app startup - starting");

        if(schedulerJobInfoRepository.findById(1L).orElse(null) == null){
            SchedulerJobInfo schedulerJobInfo = new SchedulerJobInfo();
            schedulerJobInfo.setCronExpression("0/30 * * ? * * *");
            schedulerJobInfo.setJobClass("com.helixz.quartz.demo.jobs.SampleCronJob");
            schedulerJobInfo.setJobGroup("Test_Cron");
            schedulerJobInfo.setJobName("Sample Cron");
            schedulerJobInfo.setCronJob(true);
            schedulerJobInfo.setRepeatTime(null);
            schedulerJobInfoRepository.save(schedulerJobInfo);
        }
        try {
            schedulerService.startAllSchedulers();
            log.info("Schedule all new scheduler jobs at app startup - complete");
        } catch (Exception ex) {
            log.error("Schedule all new scheduler jobs at app startup - error", ex);
        }
    }
}
