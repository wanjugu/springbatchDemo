package learn.academics.springbatch.controller;


import learn.academics.springbatch.service.JobService;
import lombok.Data;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
@Data
public class JobController {

    private final JobService jobService;

    @Autowired
    JobOperator jobOperator;

    @GetMapping("/start/{jobName}")
    public ResponseEntity<?> startJob(@PathVariable String jobName) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {

        jobService.InitBatchJobs(jobName);
        return new ResponseEntity<>("Batch Job triggered. You will be notified on email once the process is complete", HttpStatus.OK);

    }

    @GetMapping("/stop/{jobExecutionId}")
    public String stopJob(@PathVariable long jobExecutionId){

        try{
            jobOperator.stop(jobExecutionId);

        }catch(Exception ex){

            ex.printStackTrace();
        }
        return  "Job Stopped....";
    }


}
