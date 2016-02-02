package org.bl.algorithm;

import org.bl.algorithm.jaxb.GetAlgorithmABWithoutIfRequest;
import org.bl.algorithm.jaxb.GetAlgorithmABWithoutIfResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * Created by Богдан on 01.02.2016.
 */
public class AlgorithmClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(AlgorithmClient.class);

    public GetAlgorithmABWithoutIfResponse getAlgorithmABWithoutIfResponse(int a, int b) {

        GetAlgorithmABWithoutIfRequest request = new GetAlgorithmABWithoutIfRequest();
        request.setA(a);
        request.setB(b);

        log.info("Requesting which value is bigger  %d or %d" + a, b);

        GetAlgorithmABWithoutIfResponse response = (GetAlgorithmABWithoutIfResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request,
                        new SoapActionCallback("http://localhost:10080/ws/GetAlgorithmABWithoutIfResponse"));
        printResponse(response);

        return response;
    }

    public void printResponse(GetAlgorithmABWithoutIfResponse response) {

        int larger = response.getLarger();

        log.info("larger is " + larger);

    }

}
