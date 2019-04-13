package froebera.dadjokeservice.controller;

import froebera.dadjokeservice.model.JokeResponse;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class JokeController {
    private final String API_URL = "https://icanhazdadjoke.com/";

    public JokeController() {

    }

    @GetMapping("/joke")
    public JokeResponse joke() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<JokeResponse> res = restTemplate.exchange(API_URL, HttpMethod.GET, new HttpEntity(headers), JokeResponse.class);

        return res.getBody();
    }
}
