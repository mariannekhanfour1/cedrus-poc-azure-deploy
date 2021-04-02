package com.tutorial.spring.services;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class RestClient
{
    public static final String REST_SERVICE_URL = "http://localhost:8080/rest/";

    private static HttpHeaders getHeaders ()
    {
        String adminuserCredentials = "rmtuser:rmtuser";
        String encodedCredentials =
                new String(Base64.encodeBase64(adminuserCredentials.getBytes()));

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Basic " + encodedCredentials);
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return httpHeaders;
    }

    public static void checkRule()
    {
        System.out.println("Checking Rule");
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = getHeaders();

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<String> responseEntity = restTemplate.exchange(REST_SERVICE_URL,
                HttpMethod.GET, httpEntity, String.class);

        if(responseEntity.hasBody())
        {
            System.out.println("Received: " + responseEntity.getBody());
            //JSONObject jsonObject = new JSONObject(responseEntity.getBody());
            // System.out.println(jsonObject.get("firstname"));
            // System.out.println(jsonObject.get("lastname"));
        }
        else
        {
            System.out.println("Rule not found");
        }
    }
}