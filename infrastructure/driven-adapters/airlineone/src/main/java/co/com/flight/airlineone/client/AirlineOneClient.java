package co.com.flight.airlineone.client;

import co.com.flight.airlineone.request.AirlineOneRequest;
import co.com.flight.airlineone.response.AirlineOneResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


import java.util.List;


import java.util.ArrayList;
import java.util.Arrays;

@Service
public class AirlineOneClient implements IAirlineOneClient {

    private final String endpointUrl = "https://mockend.com/api/mockend/demo/posts";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<AirlineOneResponse> fetchData(AirlineOneRequest request) {
        try {
            String url = buildUrlWithSearchParams(request);
            AirlineOneResponse[] responseBody = restTemplate.getForObject(url, AirlineOneResponse[].class);
            if (responseBody != null) {
                return Arrays.asList(responseBody);
            }
        } catch (RestClientException e) {
            System.err.println("Error al realizar la solicitud al servidor:");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Se ha producido un error inesperado:");
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private String buildUrlWithSearchParams(AirlineOneRequest request) {
        StringBuilder urlBuilder = new StringBuilder(endpointUrl);
        urlBuilder.append("?");

        if (request.getOrigin() != null) {
            urlBuilder.append("origin=").append(request.getOrigin()).append("&");
        }
        if (request.getDestination() != null) {
            urlBuilder.append("destination=").append(request.getDestination()).append("&");
        }
        if (request.getDepartureDate() != null) {
            urlBuilder.append("departureDate=").append(request.getDepartureDate()).append("&");
        }
        if (request.getReturnDate() != null) {
            urlBuilder.append("returnDate=").append(request.getReturnDate()).append("&");
        }
        if (request.getPassengerCount() != null) {
            urlBuilder.append("passengerCount=").append(request.getPassengerCount()).append("&");
        }

        if (urlBuilder.charAt(urlBuilder.length() - 1) == '&') {
            urlBuilder.deleteCharAt(urlBuilder.length() - 1);
        }

        return urlBuilder.toString();
    }
}



