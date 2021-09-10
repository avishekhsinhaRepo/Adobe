package com.training.core.schedulers;


import org.apache.sling.commons.scheduler.Job;
import org.apache.sling.commons.scheduler.JobContext;

public class TrainingMultipleJobsScheduler implements Job {



    @Override
    public void execute(JobContext jobContext) {
        System.out.println(jobContext.getConfiguration());
    }
}
