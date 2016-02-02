package org.bl.algorithm;

import org.bl.algorithm.jaxb.GetAlgorithmABWithoutIfResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by Богдан on 01.02.2016.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    int lookup(AlgorithmClient algorithmClient) {
        int a = 5;
        int b = 7;

        return algorithmClient.getAlgorithmABWithoutIfResponse(a, b).getLarger();

    }
}
