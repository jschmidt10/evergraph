package org.jeff.evergraph.service;

/**
 * A rest response. Gives the status, error message, and data.
 */
public class RestResponse {

	/**
	 * A successful response.
	 * @param data
	 * @return response
	 */
	public static RestResponse success(Object data) {
		return new RestResponse(true, "", data);
	}

	/**
	 * A failure response.
	 * @param error
	 * @return response
	 */
	public static RestResponse failure(String message) {
		return new RestResponse(false, message, null);
	}

	private boolean success;
	private String message;
	private Object data;

	public RestResponse(boolean success, String message, Object data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}
}
