package com.kraken.model;

public class Values {
	/**
	 * @author Gustavo
	 * All types of data accepted by default
	 */
	public static final Integer TYPE_INTEGER = 0;
	public static final Integer TYPE_STRING = 1;
	
	
	/**
	 * @author Gustavo
	 * Both http data send types
	 */
	public static final Integer GET_REQUEST = 0;
	public static final Integer POST_REQUEST = 1;
	
	/**
	 * @author Gustavo
	 * Some types of timeout fot http connections
	 */
	public static final Integer TIMEOUT_LONGER = 0;
    public static final Integer TIMEOUT_LONG = 1;
    public static final Integer TIMEOUT_MEDIUM = 2;
    public static final Integer TIMEOUT_SHORT = 3;
}
