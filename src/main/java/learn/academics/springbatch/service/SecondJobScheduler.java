package learn.academics.springbatch.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SecondJobScheduler {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job secondJob;

    //http://www.cronmaker.com/
    @Scheduled(cron = "0 0/1 * 1/1 * ?")  //Run everty 1 minute
    public void secondJobStarter(){

        Map<String, JobParameter> params = new HashMap<>();
        params.put("currentTimeinms", new JobParameter(System.currentTimeMillis()));

        String jobName = "Second Job";
        JobParameters jobParameters = new JobParameters(params);

        try{
            JobExecution jobExecution = jobLauncher.run(secondJob, jobParameters);

            System.out.println("++++++ Schedular Job Execution ID::" + jobExecution.getId());

        }catch(Exception ex) {
            System.out.println("++++ Exception encountered while initiating batch Job!!");
            ex.printStackTrace();
        }

    }
}
