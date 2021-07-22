package com.mobiquity.atmlocator.util.client;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiquity.atmlocator.dto.AtmObj;
import lombok.val;
import lombok.var;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class AtmRestClient {

    ObjectMapper objectMapper = new ObjectMapper();

    private AtmRestClient(){ }

    private static AtmRestClient atmRestClient;

    public static AtmRestClient getInstance()
    {
        if (atmRestClient == null)
            atmRestClient = new AtmRestClient();
        return atmRestClient;
    }


    public List<AtmObj> getATMs(String atmLocatorUrl) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity(atmLocatorUrl, String.class);
        String requireNonNull = Objects.requireNonNull(result.getBody());
        String data = requireNonNull.substring(requireNonNull.indexOf('['));
        return parseJsonArray(data, AtmObj.class);
    }


    public <T> List<T> parseJsonArray(String json, Class<T> clazz) throws JsonProcessingException {
        var tree = objectMapper.readTree(json);
        var list = new ArrayList<T>();
        for (JsonNode jsonNode : tree) {
            list.add(objectMapper.treeToValue(jsonNode, clazz));
        }
        return list;
    }

}
