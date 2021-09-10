package com.training.core.schedulers;

import com.training.core.config.TrainingSchedulerOSGiConfig;
import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;

@Component(immediate = true,service = Runnable.class)
@Designate(ocd = TrainingSchedulerOSGiConfig.class)
public class TrainingScheduler implements Runnable{

    @Reference
    Scheduler scheduler;

    private int schedulerId;

    @Activate
    public void activate(TrainingSchedulerOSGiConfig trainingSchedulerOSGiConfig){
        schedulerId = trainingSchedulerOSGiConfig.scheduleName().hashCode();
        ScheduleOptions scheduleOptions = scheduler.EXPR(trainingSchedulerOSGiConfig.cronExpression());
        scheduleOptions.name(String.valueOf(schedulerId));
        scheduleOptions.canRunConcurrently(true);
        scheduler.schedule(this,scheduleOptions);
    }

    @Deactivate
    public void deActivate(TrainingSchedulerOSGiConfig trainingSchedulerOSGiConfig){
        scheduler.unschedule(String.valueOf(schedulerId));
    }
    @Override
    public void run() {
        System.out.println("Run method- This is where Logic Reside");
    }
}
