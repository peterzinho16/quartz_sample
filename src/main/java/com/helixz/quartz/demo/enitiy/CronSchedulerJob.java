package com.helixz.quartz.demo.enitiy;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;


@Getter
@Setter
@Entity
public class CronSchedulerJob {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "pg-uuid"
    )
    @GenericGenerator(
            name = "pg-uuid",
            strategy = "uuid2",
            parameters = @org.hibernate.annotations.Parameter(
                    name = "uuid_gen_strategy_class",
                    value = "com.helixz.quartz.demo.component.PostgreSQLUUIDGenerationStrategy"
            )
    )
    @Column(name = "CronSchedulerJobId")
    private UUID id;

    @Column(nullable = false, updatable = false, insertable = false)
    private String jobName;

    @Column(nullable = false, updatable = false, insertable = false)
    private String jobGroup;

    @Column(nullable = false, updatable = false, insertable = false)
    private String jobClass;

    @Column(nullable = false, updatable = false, insertable = false)
    private String seconds;

    @Column(nullable = false, updatable = false, insertable = false)
    private String minutes;

    @Column(nullable = false, updatable = false, insertable = false)
    private String hours;

    @Column(nullable = false, updatable = false, insertable = false)
    private String daysOfMonth;

    @Column(nullable = false, updatable = false, insertable = false)
    private String months;

    @Column(nullable = false, updatable = false, insertable = false)
    private String daysOfWeek;

    @Column(nullable = false, updatable = false, insertable = false)
    private String years;

    @Column(nullable = false, updatable = false, insertable = false)
    private String cronExpression;

}
