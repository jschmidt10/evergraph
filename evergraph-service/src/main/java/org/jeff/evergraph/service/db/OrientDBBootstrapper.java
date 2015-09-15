package org.jeff.evergraph.service.db;

import java.io.File;

import com.orientechnologies.orient.server.OServer;
import com.orientechnologies.orient.server.OServerMain;

/**
 * Creates the embedded OrientDB server.
 */
public class OrientDBBootstrapper {

	/**
	 * Create the embedded server.
	 */
	public static void init() {
		try {
			OServer server = OServerMain.create(true);
			server.startup(new File("orientdb-server-config.xml"));
			server.activate();
		} catch (Exception e) {
			throw new RuntimeException("Could not start up OrientDB", e);
		}
	}
}
