package learn.academics.springbatch.config;


import learn.academics.springbatch.listeners.SampleJobListener;
import learn.academics.springbatch.listeners.SampleStepListener;
import learn.academics.springbatch.processor.FirstItemProcessor;
import learn.academics.springbatch.reader.FirstItemReader;
import learn.academics.springbatch.service.Secondtask;
import learn.academics.springbatch.writer.FirstItemWriter;
import org.hibernate.id.IncrementGenerator;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleJob {


    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private Secondtask secondtask;

    @Autowired
    private SampleJobListener jobListener;

    @Autowired
    private SampleStepListener stepListener;

    @Autowired
    FirstItemReader firstItemReader;

    @Autowired
    FirstItemProcessor firstItemProcessor;

    @Autowired
    FirstItemWriter firstItemWriter;



    @Bean
    public Job firstJob(){
        RunIdIncrementer incrementor = new RunIdIncrementer();
        System.out.println("Increntor Value:::");
        return jobBuilderFactory.get("First Job")
                .incrementer(new RunIdIncrementer())
                .listener(jobListener)
                .start(firstStep())
                .next(secondStep())
                .build();
    }



    private Step firstStep(){
        return stepBuilderFactory.get("First Step")
                .tasklet(firstTask())
                .listener(stepListener)
                .build();
    }

    private Step secondStep(){
        return stepBuilderFactory.get("Second Step")
                .tasklet(secondtask)
                .build();
    }


    private Tasklet firstTask(){
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

                System.out.println("++++++First tasklet step");
                return RepeatStatus.FINISHED;
            }
        };
    }


    /*
     *Chunk Oriented Step -- example
    */

    @Bean
    public Job secondJob(){

        return jobBuilderFactory.get("Second Job")
                .incrementer(new RunIdIncrementer())
                .start(firstChunkStep())
                .build();
    }

    private Step firstChunkStep(){
        return stepBuilderFactory.get("First Chunk Step")
                .<Integer, Long>chunk(5)
                .reader(firstItemReader)
                .processor(firstItemProcessor)
                .writer(firstItemWriter)
                .build();
    }
//    private Tasklet secondTask(){
//        return new Tasklet() {
//            @Override
//            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//
//                System.out.println("++++++Second tasklet step");
//                return RepeatStatus.FINISHED;
//            }
//        };
//    }
}
