package org.jeff.evergraph.service.model;

/**
 * The configuration for a single graph node.
 */
public class Node {
	private String id;
	private Position position;

	public Node(String id, Position position) {
		this.id = id;
		this.position = position;
	}

	public String getId() {
		return id;
	}

	public Position getPosition() {
		return position;
	}

}