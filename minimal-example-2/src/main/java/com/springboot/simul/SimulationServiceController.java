package com.springboot.simul;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimulationServiceController {
	@Autowired
	private SimulationServiceService simulService;

	@PostMapping(path = "/simulate", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> simulateModel(HttpServletRequest request) throws JSONException {

		JSONObject obj = new JSONObject();
		
		obj = obj.put("result", simulService.simulateSequence());

		return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
	}
}
