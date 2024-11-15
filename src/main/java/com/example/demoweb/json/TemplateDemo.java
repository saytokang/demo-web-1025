package com.example.demoweb.json;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TemplateDemo {

	@PostConstruct
	private void init() {
		String jsonTemplate = """
				    {
				        "user" : "#{user}",
				        "name" : "#{name}",
				        "id" : "#{id}"
				    }
				""";

		Map<String, Object> m1 = new HashMap<String, Object>() {
			{
				put("user", "u1");
				put("name", "ohng");
				put("id", 1);
			}
		};
		Map<String, Object> m2 = new HashMap<String, Object>() {
			{
				put("user", "u2");
				put("name", "lee");
				put("id", 2);
			}
		};

		var values = Arrays.asList(m1, m2);

		// var replacedJsonObjects = JsonTemplateReplacer.replacePlaceholdersInTemplate(jsonTemplate, values);

		// for (JSONObject jsonObject : replacedJsonObjects) {
		// 	System.out.println(jsonObject.toString(2)); // Pretty print JSON
		// }

        // var rs = JsonTemplateReplacer.replacePlaceholdersInTemplateInArray(jsonTemplate, values);
        // log.info("{}", rs.toString(2));

        var rs = new JSONArray();
        rs.put(values);

        log.info("{}", rs.toString(2));
	}

}
