package learn.academics.springbatch.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class JobService {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job firstJob;

    @Autowired
    Job secondJob;

    @Async
    public void InitBatchJobs(String jobName){

        Map<String, JobParameter> params = new HashMap<>();
        params.put("currentTimeinms", new JobParameter(System.currentTimeMillis()));

        String response = "Job Started success!";

        try{

            if(jobName.equalsIgnoreCase("First Job")){
                System.out.println("Running First Job");
                jobLauncher.run(firstJob, new JobParameters(params));

            }else if(jobName.equalsIgnoreCase("Second Job")){
                System.out.println("Running Second Job");
                jobLauncher.run(secondJob, new JobParameters(params));
            }else{
                System.out.println("Unknown Job");
                response = "Unknown Job";
            }

        }catch(Exception ex) {
            System.out.println("++++ Exception encountered while initiating batch Job!!");
            response = "++++ Exception encountered while initiating batch Job!!";
            ex.printStackTrace();
        }

    }
}
