package co.com.flight.api;

import co.com.flight.usecase.searchflights.SearchFlightsUseCase;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest(classes = ApiRest.class)
@AutoConfigureMockMvc
 class ApiRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SearchFlightsUseCase useCase;

    @Test
    void testApiEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/flight")
                        .param("origin", "JFK")
                        .param("destination", "LAX")
                        .param("passengers", "2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

}
