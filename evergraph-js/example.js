$(function() { // on dom ready

	$('#cy').cytoscape({
		style : cytoscape.stylesheet().selector('node').css({
			'content' : 'data(name)',
			'text-valign' : 'center',
			'background-color' : 'black',
			'color' : 'white',
			'width' : 50,
			'height' : 50,
			'text-color' : 'white',
			'text-outline-width' : 0
		}).selector('edge').css({
			'line-color' : 'black',
			'target-arrow-color' : 'black',
			'target-arrow-shape' : 'triangle'
		}),

		elements : {
			nodes : [ {
				data : {
					id : 'Jeff',
					name : 'Jeff'
				}
			}, {
				data : {
					id : 'John',
					name : 'John'
				}
			}, {
				data : {
					id : 'Google',
					name : 'Google'
				}
			}, {
				data : {
					id : 'Brandon',
					name : 'Brandon'
				}
			} ],
			edges : [ {
				data : {
					source : 'Jeff',
					target : 'John',
					label : 'hasBrother'
				}
			}, {
				data : {
					source : 'John',
					target : 'Brandon',
					label : 'hasFriend'
				}
			}, {
				data : {
					source : 'Jeff',
					target : 'Google',
					label : 'visited'
				}
			}, {
				data : {
					source : 'John',
					target : 'Google',
					label : 'visited'
				}
			} ]
		},

		layout : {
			name : 'grid',
			animate: false,
			padding : 10
		},

		// on graph initial layout done (could be async depending on layout...)
		ready : function() {
			window.cy = this;

			cy.$('#Jeff').position({ x: 300, y: 125 });
			
//			cy.elements().unselectify();
//
//			cy.on('tap', 'node', function(e) {
//				var node = e.cyTarget;
//				var neighborhood = node.neighborhood().add(node);
//
//				cy.elements().addClass('faded');
//				neighborhood.removeClass('faded');
//			});
//
//			cy.on('tap', function(e) {
//				if (e.cyTarget === cy) {
//					cy.elements().removeClass('faded');
//				}
//			});
		}
	});

}); // on dom ready
