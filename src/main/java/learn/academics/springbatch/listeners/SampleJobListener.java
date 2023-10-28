package learn.academics.springbatch.listeners;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;


@Component
public class SampleJobListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("Executing beforeJob Listener\n");

        System.out.println("JobID:::"+ jobExecution.getJobId());
        System.out.println("JobParams:::"+ jobExecution.getJobParameters());
        System.out.println("ExecutionContent:::"+ jobExecution.getExecutionContext());
        jobExecution.getExecutionContext().put("Test", "Test Context");

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("Executing afterJob Listener ");

        System.out.println("JobID:::"+ jobExecution.getJobId());
        System.out.println("JobParams:::"+ jobExecution.getJobParameters());
        System.out.println("ExecutionContent:::"+ jobExecution.getExecutionContext());

    }
}
