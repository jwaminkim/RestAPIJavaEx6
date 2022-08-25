package com.maven.ex6.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/restapi")
//@Controller
public class RestAPIController {

	@GetMapping(path = "/api")
	public String Get(
		@RequestParam(name="param1", defaultValue="true") String param1,
		@RequestParam(name="param2", defaultValue="false") String param2
		) {

		return "param1: "+param1+", param2: ";
	}
	
	@GetMapping(path = "/list")
	public String GetRestAPI() {
		String testval = "api";
		
		return testval;
	}
	
	//@RequestMapping(value = "/list", method = RequestMethod.GET)
	//@RequestMapping("/restapi")
	@GetMapping("/list/v1")
	@ResponseBody
    public String Get() 
	{
		try 
		{
			/*
			String jsonValue = "{\"id\" : \"jwaminkim\", \"value\" : \"1\" }";
	        var jsonobj = new JSONObject(jsonValue);
	        
	        String resultVal = jsonobj.toString();
			return resultVal;
			*/
			List<HashMap<String, Object>> resultMapList = new ArrayList<HashMap<String, Object>>();
	        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        		        
	        resultMap.put("id", "jwaminkim");
	        resultMap.put("name", "김좌민");    	
	        resultMap.put("nick", "kjm");
	        resultMap.put("value", "1");   
	        
	        resultMapList.add(resultMap);
	        
	        resultMap = new HashMap<String, Object>();
	        //resultMap.clear();
	        
	        resultMap.put("id", "doongyookim");
	        resultMap.put("name", "김동우");    	
	        resultMap.put("nick", "kdy");
	        resultMap.put("value", "2");   
	        
	        resultMapList.add(resultMap);
	        
	        String resultVal = mapToJson(resultMapList);
			//Map<String, Object> deResultMap = jsonToMap(resultVal);    
			return resultVal;
		}
		catch (Exception ex)
		{
			return ex.getMessage();
		}
		
	}
	
	public String mapToJson(List<HashMap<String, Object>> map) throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        
        return mapper.writeValueAsString(map);
    }
	
	public Map<String, Object> jsonToMap(String json) throws Exception
	{
	    ObjectMapper objectMapper = new ObjectMapper();
	    TypeReference<Map<String, Object>> typeReference = new TypeReference<Map<String,Object>>() {};
	    
	    return objectMapper.readValue(json, typeReference);
	}
}
