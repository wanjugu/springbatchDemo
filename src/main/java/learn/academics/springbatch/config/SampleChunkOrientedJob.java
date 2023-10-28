//package learn.academics.springbatch.config;
//
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SampleChunkOrientedJob {
//
//    @Autowired
//    JobBuilderFactory jobBuilderFactory;
//
//    @Bean
//    public Job secondJob(){
//
//        return jobBuilderFactory.get("Second Job")
//                .incrementer(new RunIdIncrementer())
//                .build();
//    }
//
//}
