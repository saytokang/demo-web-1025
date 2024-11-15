package com.example.demoweb.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonTemplateReplacer {

	public static List<JSONObject> replacePlaceholdersInTemplate(String jsonTemplate,
			List<Map<String, Object>> values) {
		List<JSONObject> resultList = new ArrayList<>();

		for (Map<String, Object> valueMap : values) {
			JSONObject jsonObject = new JSONObject(jsonTemplate); // Parse the template
			for (String key : valueMap.keySet()) {
				var placeholder = String.format("#{%s}", key);
				var templateString = jsonObject.toString();
				jsonObject = new JSONObject(templateString.replace(placeholder, valueMap.get(key).toString()));
			}
			resultList.add(jsonObject);
		}

		return resultList;
	}

	public static JSONArray replacePlaceholdersInTemplateInArray(String jsonTemplate,
			List<Map<String, Object>> values) {
		var jsonArray = new JSONArray();

		for (Map<String, Object> valueMap : values) {
			JSONObject jsonObject = new JSONObject(jsonTemplate); // Parse the template
			for (String key : valueMap.keySet()) {
				var placeholder = String.format("#{%s}", key);
				var templateString = jsonObject.toString();
				jsonObject = new JSONObject(templateString.replace(placeholder, valueMap.get(key).toString()));
			}
			jsonArray.put(jsonObject);
		}

		return jsonArray;
	}

}
