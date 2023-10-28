package learn.academics.springbatch.listeners;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SampleStepListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("Before Step::" + stepExecution.getStepName() );
        System.out.println("JOb  Execution Context::" + stepExecution.getJobExecution().getExecutionContext() );
        System.out.println("Step Executiin context " + stepExecution.getExecutionContext());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("After Step::" + stepExecution.getStepName() );
        System.out.println("JOb  Execution Context::" + stepExecution.getJobExecution().getExecutionContext() );
        System.out.println("Step Executiion context " + stepExecution.getExecutionContext());
        return null;
    }
}
