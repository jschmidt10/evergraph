package org.jeff.evergraph.service.db;

import java.util.List;

import javax.annotation.PreDestroy;

import org.jeff.evergraph.service.model.GraphConfig;
import org.jeff.evergraph.service.model.Position;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;

/**
 * A graph dao backed by orientDB.
 */
@Repository
public class OrientDBGraphDAO implements GraphDAO {

	public static final String DB = "remote:localhost/evergraph";

	private ThreadLocal<OObjectDatabaseTx> threadDb = new ThreadLocal<>();

	static {
		OrientDBBootstrapper.init();
	}

	public OrientDBGraphDAO() throws Exception {
	}

	private OObjectDatabaseTx db() {
		if (threadDb.get() == null) {
			OObjectDatabaseTx db = new OObjectDatabaseTx(DB);
			db.open("root", "123root321");

			db.getEntityManager().registerEntityClass(Position.class);
			db.getEntityManager().registerEntityClass(GraphConfig.class);

			threadDb.set(db);
		}

		return threadDb.get();
	}

	@PreDestroy
	public void destroy() {
		db().close();
	}

	@Override
	public GraphConfig getById(String id) {
		OSQLSynchQuery<GraphConfig> query = new OSQLSynchQuery<GraphConfig>("select from GraphConfig where id = ?");
		List<GraphConfig> queryResults = db().command(query).execute(id);

		GraphConfig result = null;

		if (!queryResults.isEmpty()) {
			result = queryResults.get(0);
		}

		return result;
	}

	@Override
	public boolean save(GraphConfig config) {
		return db().save(config) != null;
	}
}
