package org.jeff.evergraph.service.db;

import org.jeff.evergraph.service.model.GraphConfig;

/**
 * Stores and retrieves information from the underlying data source.
 */
public interface GraphDAO {

	/**
	 * Get the graph config by id;
	 * @param id
	 * @return config
	 */
	GraphConfig getById(String id);
	
	/**
	 * Save the graph config. 
	 * @param config
	 * @return true if saved successfully, false, otherwise
	 */
	boolean save(GraphConfig config);
}
