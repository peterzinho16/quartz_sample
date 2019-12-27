package com.helixz.quartz.demo.repository;

import com.helixz.quartz.demo.enitiy.SchedulerJobInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Chamith
 */
@Repository
@Transactional
public interface SchedulerRepository extends JpaRepository<SchedulerJobInfo, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "update seller\n" +
            "set can_sell= false\n" +
            "where general_user_id in (select sb.seller_id\n" +
            "                          from seller_bag sb\n" +
            "                                   inner join seller s on sb.seller_id = s.general_user_id\n" +
            "                                   inner join distributor d on s.distributor_id = d.general_user_id\n" +
            "                                   inner join general_user gu on sb.seller_id = gu.general_user_id\n" +
            "                          where sb.spent > 0\n" +
            "                            AND d.general_user_id in\n" +
            "                                (select distributor_id from interruption where sec_time = :hourInterruptionInSeconds and enabled = true)\n" +
            "                            AND gu.enabled = true\n" +
            "                            AND sb.enabled = true)")
    void updateSellers(Integer hourInterruptionInSeconds);

}
