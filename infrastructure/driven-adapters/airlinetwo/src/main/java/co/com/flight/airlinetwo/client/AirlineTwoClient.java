package co.com.flight.airlinetwo.client;

import co.com.flight.airlinetwo.request.AirlineTwoRequest;
import co.com.flight.airlinetwo.response.AirlineTwoResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class AirlineTwoClient implements IAirlineTwoClient {

    private final String endpointUrl = "https://mockend.com/api/nymer1ax/flight/airport2";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<AirlineTwoResponse> fetchData(AirlineTwoRequest request) {
        try {
            String url = buildUrlWithSearchParams(request);
            AirlineTwoResponse[] responseBody = restTemplate.getForObject(url, AirlineTwoResponse[].class);
            if (responseBody != null) {
                return Arrays.asList(responseBody);
            }
        } catch (RestClientException e) {
            return new ArrayList<>();
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }

    private String buildUrlWithSearchParams(AirlineTwoRequest request) {
        StringBuilder urlBuilder = new StringBuilder(endpointUrl);
        urlBuilder.append("?");

        if (request.getFrom() != null) {
            urlBuilder.append("from=").append(request.getFrom()).append("&");
        }
        if (request.getTo() != null) {
            urlBuilder.append("to=").append(request.getTo()).append("&");
        }
        if (request.getOutboundDate() != null) {
            urlBuilder.append("outboundDate=").append(request.getOutboundDate()).append("&");
        }
        if (request.getInboundDate() != null) {
            urlBuilder.append("inboundDate=").append(request.getInboundDate()).append("&");
        }
        if (request.getNumberOfAdults() != null) {
            urlBuilder.append("numberOfAdults=").append(request.getNumberOfAdults()).append("&");
        }

        if (urlBuilder.charAt(urlBuilder.length() - 1) == '&') {
            urlBuilder.deleteCharAt(urlBuilder.length() - 1);
        }

        return urlBuilder.toString();
    }



}
