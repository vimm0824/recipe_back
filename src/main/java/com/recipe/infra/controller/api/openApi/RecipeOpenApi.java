package com.recipe.infra.controller.api.openApi;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RecipeOpenApi {

	public List<Map<String, Object>> getSearchOpenRecipe(String search, String category, List<String> ingredients) {
		
		String jsonString = "";
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders header = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(header);
        
        String url = "http://openapi.foodsafetykorea.go.kr/api";
        String key = "/26291537af9a493881b0";
        String code = "/COOKRCP01";
        String type = "/json";
        String page = "/1/10/";
        
        if (search.length() > 0) {
        	search = "RCP_NM=" + search + "&";
        } else {
        	search = "";
        }
        
        if (category.length() > 0) {
        	category = "RCP_PAT2=" + category + "&";
        } else {
        	category = "";
        }
        
        String ingredient = "";
        
        for (String in : ingredients) {
        	if (in.length() > 0) {
        		ingredient = "RCP_PARTS_DTLS=" + in + "&";
            } 
        }
        
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url + key + code + type + page + search + category + ingredient).build();
        
        ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);
        
        ObjectMapper mapper = new ObjectMapper();
        try {
			jsonString = mapper.writeValueAsString(resultMap.getBody());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
        
        Map<String, Object> map = null;
        // 원하는 결과 값
        Map<String, Object> cookrcp01 = null;
        
        List<Map<String, Object>> result = null;
        
        try {
        	map = new ObjectMapper().readValue(jsonString, Map.class);
			String mapKey = "";
			for (String menu : map.keySet()) {
				mapKey = menu;
			}
			cookrcp01 = (Map<String, Object>) map.get(mapKey);
			for (String menu : cookrcp01.keySet()) {
				mapKey = menu;
				if (mapKey.equals("row")) {
					break;
				}
			}
			result = (List<Map<String, Object>>) cookrcp01.get(mapKey);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
        
        return result;
	}
}
