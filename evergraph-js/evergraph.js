/**
 * The evergraph module.
 */
var evergraph = function() {

	var me = this;

	/**
	 * Initialize evergraph with a web service url.
	 */
	this.init = function(url) {
		this.saveUrl = url + "/save";
		this.fetchUrl = url + "/fetch";
	};

	/**
	 * Saves the current graph configuration.
	 */
	this.save = function(graphId, cy) {
		var graphConfig = me.extract(cy);
		graphConfig.id = graphId;

		$.ajax({
			type : "POST",
			url : me.saveUrl,
			data : graphConfig,
			success : function() {
				console.log("Saved graph config to " + me.saveUrl);
			},
			error : function(req, status, err) {
				console.log("Failed to POST to " + me.saveUrl);
			}
		});
	};

	/**
	 * Extracts the current graph configuration.
	 * 
	 * Currently saves zoom level, pan, and node positions.
	 */
	this.extract = function(cy) {
		var graph = {};
		graph.zoom = cy.zoom();
		graph.pan = cy.pan();

		// graph.nodes = cy.nodes().map(function(n) {
		// return {
		// id : n.id(),
		// position : {
		// x : n.position().x,
		// y : n.position().y
		// }
		// };
		// });

		return graph;
	};

	/**
	 * Apply this graphConfig to the current graph.
	 */
	this.rearrange = function(cy, graphConfig) {
		cy.zoom(graphConfig.zoom);
		cy.pan(graphConfig.pan);
		// cy.nodes().forEach(function(n) {
		//
		// var nodeConfig = graphConfig.nodes.find(function(m) {
		// return m.id == n.id();
		// });
		//
		// if (nodeConfig) {
		// cy.$('#' + n.id()).position(nodeConfig.position);
		// }
		// });
	};

	return this;

}();