package org.example.ws;

import org.example.ws.model.Greeting;
import org.example.ws.repository.GreetingRepository;
import org.example.ws.security.EnableConfigServer;
import org.example.ws.util.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.stream.Stream;

/**
 * Spring Boot main application class. Serves as both the runtime application
 * entry point and the central Java configuration class.
 * run this as a java program
 * or in command line "mvn spring-boot:run"
 * @author Matt Warman
 */
//@EnableCircuitBreaker
//@EnableHystrixDashboard   // Hystrix is Netflix implementation for the circuit-breaker design and it gives monitoring dashboard to monitor all services
//@EnableZuulProxy//for routing and load balancing
//@EnableDiscoveryClient// for eurkea -discovery services
@EnableConfigServer // for centralized configuration server location
@EnableTransactionManagement
@EnableCaching
@EnableScheduling
@EnableAsync
@SpringBootApplication
public class Application {

    /**
     * Entry point for the application.
     * 
     * @param args Command line arguments.
     * @throws Exception Thrown when an unexpected Exception is thrown from the
     *         application.
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

/**
    @Bean
    CommandLineRunner commandLineRunner(GreetingRepository greetingRepository){
         RequestContext.setUsername("systemUser");
         return strings ->  {
                            Stream.of("hi", "bye", "hello", "privet", "bless", "love", "see u", "haha")
                                  .forEach(n ->
                                                  {
                                                      greetingRepository.save(new Greeting(n));
                                                      System.out.println(n);
                                                  }
                                           );

                           };

    }
*/
}

//every class that implements CommandLineRunner will run on app. startup
@Component
class DummyDataCLR implements CommandLineRunner {
    @Autowired
    GreetingRepository repository;

    @Override
    public void run(String... strings) throws Exception{
        RequestContext.setUsername("systemUser");
        System.out.println("saving a dummy Data Collection:");
        Stream.of("hi", "bye", "hello", "privet", "bless", "love", "see u", "haha")
              .forEach(n ->
                              {
                                  repository.save(new Greeting(n));
                                  System.out.println(n);
                              }
                       );
        repository.findAll().forEach(System.out::println);
        System.out.println(repository.findOne(new Long(1))) ;
    }

}


