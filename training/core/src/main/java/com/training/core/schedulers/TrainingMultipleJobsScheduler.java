package com.training.core.schedulers;


import com.training.core.config.TrainingSchedulerOSGiConfig;
import org.apache.sling.commons.scheduler.Job;
import org.apache.sling.commons.scheduler.JobContext;
import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Component(immediate = true,service = Job.class)
@Designate(ocd = TrainingSchedulerOSGiConfig.class)
public class TrainingMultipleJobsScheduler implements Job {

    @Reference
    private Scheduler scheduler;

    private int scheduleId;

    @Activate
    protected void activate(TrainingSchedulerOSGiConfig trainingSchedulerOSGiConfig){
        scheduleId = trainingSchedulerOSGiConfig.scheduleName().hashCode();
        registerSchedulerJob(trainingSchedulerOSGiConfig);
    }

    @Deactivate
    protected void deActivate(TrainingSchedulerOSGiConfig trainingSchedulerOSGiConfig){
        scheduler.unschedule(String.valueOf(scheduleId));
    }

    private void registerSchedulerJob(TrainingSchedulerOSGiConfig trainingSchedulerOSGiConfig){
        /* Job 1 Start*/
        ScheduleOptions  in = scheduler.EXPR(trainingSchedulerOSGiConfig.cronExpression());
        Map<String, Serializable> inMap = new HashMap<>();
        inMap.put("country","in");
        inMap.put("url","www.in.com");
        in.config(inMap);
        scheduler.schedule(this,in);
        /* Job 1 End*/

        /* Job 2 Start*/
        ScheduleOptions  de = scheduler.EXPR(trainingSchedulerOSGiConfig.cronExpression());
        Map<String, Serializable> deMap = new HashMap<>();
        deMap.put("country","de");
        deMap.put("url","www.de.com");
        de.config(deMap);
        scheduler.schedule(this,de);
        /* Job 2 End*/

        /* Job 3 Start*/
        ScheduleOptions  es = scheduler.EXPR(trainingSchedulerOSGiConfig.cronExpression());
        Map<String, Serializable> esMap = new HashMap<>();
        esMap.put("country","es");
        esMap.put("url","www.es.com");
        es.config(esMap);
        scheduler.schedule(this,es);
        /* Job 3 End*/
    }

    @Override
    public void execute(JobContext jobContext) {
        Map<String, Serializable> configuration = jobContext.getConfiguration();
        String county  = configuration.get("country").toString();
        switch (county){
            case "in":
                  System.out.println("Hitting the URL>>>"+ configuration.get("url"));
                  break;
            case "de":
                System.out.println("Hitting the URL>>>"+ configuration.get("url"));
                break;
            case "es":
                System.out.println("Hitting the URL>>>"+ configuration.get("url"));
                break;
        }

    }
}
