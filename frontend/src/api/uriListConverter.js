/**
 * Convert a single or array of resources into "URI1\nURI2\nURI3..."
 * */
/* eslint no-undef: "off"*/
define(function() {

	return {
		read: function(str /*, opts */) {
			return str.split('\n');
		},
		write: function(obj /*, opts */) {
			// If this is an Array, extract the self URI and then join using a newline
			if (obj instanceof Array) {
				return obj.map(resource => resource._links.self.href).join('\n');
			} else { // otherwise, just return the self URI
				return obj._links.self.href;
			}
		}
	};

});
