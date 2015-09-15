package org.jeff.evergraph.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * An evergraph graph configuration.
 */
@JsonIgnoreProperties("handler")
public class GraphConfig {

	private String id;
	private double zoom;
	private Position pan;
	
	public GraphConfig() {
	}
	
	public GraphConfig(String id, double zoom, Position pan) {
		this.id = id;
		this.zoom = zoom;
		this.pan = pan;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public double getZoom() {
		return zoom;
	}
	
	public void setZoom(double zoom) {
		this.zoom = zoom;
	}

	public Position getPan() {
		return pan;
	}
	
	public void setPan(Position pan) {
		this.pan = pan;
	}
}
