package org.bl.algorithm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * Created by Богдан on 01.02.2016.
 */
@Configuration
public class AlgorithmConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("org.bl.algorithm.jaxb");
        return marshaller;
    }

    @Bean
    public AlgorithmClient algorithmClient(Jaxb2Marshaller marshaller) {
        AlgorithmClient client = new AlgorithmClient();
        client.setDefaultUri("http://localhost:10080/wsf");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
