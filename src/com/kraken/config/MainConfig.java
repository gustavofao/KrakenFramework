package com.kraken.config;

public class MainConfig extends com.kraken.model.Values{
	
	public final CacheConfig cacheConfig = new CacheConfig();
	
	public class CacheConfig{
		public String CacheName = "Kraken";
		public String[] tags = {
						"id",
						"name",
					};
		public Integer[] tagType = {
						TYPE_INTEGER,
						TYPE_STRING,
					};
	}
	
	

}
