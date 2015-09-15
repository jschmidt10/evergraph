package org.jeff.evergraph.service;

import org.jeff.evergraph.service.db.GraphDAO;
import org.jeff.evergraph.service.model.GraphConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("evergraph")
@SpringBootApplication
public class EvergraphServiceApplication {

	@Autowired
	private GraphDAO graphDao;

	public EvergraphServiceApplication() {
	}

	public EvergraphServiceApplication(GraphDAO graphDao) {
		this.graphDao = graphDao;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponse saveConfig(@RequestBody GraphConfig graphConfig) {
		return RestResponse.success(graphDao.save(graphConfig));
	}
	
	@RequestMapping(value = "fetch", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public RestResponse fetchConfig(@RequestParam String id) {
		return RestResponse.success(graphDao.getById(id));
	}

	public static void main(String[] args) {
		SpringApplication.run(EvergraphServiceApplication.class, args);
	}
}
