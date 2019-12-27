package com.helixz.quartz.demo.repository;

import com.helixz.quartz.demo.enitiy.SchedulerJobInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SchedulerJobInfoRepository extends CrudRepository<SchedulerJobInfo, Long> {
}
