package com.tutorial.spring.services;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import com.tutorial.spring.entities.Person;

public class RestClient
{
    public static final String REST_SERVICE_URL = "http://13.68.76.255:9090/DecisionService/rest/v1/medicaid_service/1.0/eligibility";

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

    public static Object checkRule(Person person)
    {
        System.out.println("Checking Rule");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = getHeaders();
        HttpEntity<Person> httpEntity = new HttpEntity<>(person, httpHeaders);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(REST_SERVICE_URL,
                httpEntity, String.class);

        if(responseEntity.hasBody())
        {
            System.out.println("Received: " + responseEntity.getBody());
            JSONObject jsonObject = new JSONObject(responseEntity.getBody());
            System.out.println(jsonObject.get("eligible"));
            return jsonObject.get("eligible");
        }
        else
        {
            System.out.println("Rule not found");
            return false;
        }
    }
}