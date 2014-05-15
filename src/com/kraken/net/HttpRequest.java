package com.kraken.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * @author Gustavo
 * @category WebComunication
 * Based on JSONParser from Ravi Tamada
 * @see http://www.androidhive.info/2012/05/how-to-connect-android-with-php-mysql/
 * @extends Values for request types and timeouts
 */
public class HttpRequest extends com.kraken.config.MainConfig{

	private InputStream is = null;
	
	public JSONObject RequestAsJson(List<NameValuePair> params,
			Integer timeOut, int method, String url) throws JSONException{
		return new JSONObject(makeRequest(params, timeOut, method, url));
	}
	
	public String RequestAsString(List<NameValuePair> params,
			Integer timeOut, int method, String url){
		return makeRequest(params, timeOut, method, url);
	}
	
	private String makeRequest(List<NameValuePair> params,
			Integer timeOut, int method, String url){
		String requestResult = "";
		try{
			if(method == POST_REQUEST){
				DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(url);
                httpPost.setEntity(new UrlEncodedFormEntity(params));
 
                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();
			} else if (method == GET_REQUEST){
				DefaultHttpClient httpClient = new DefaultHttpClient();
                String paramString = URLEncodedUtils.format(params, "utf-8");
                url += "?" + paramString;
                HttpGet httpGet = new HttpGet(url);
 
                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();
			}
		} catch (UnsupportedEncodingException e){
			Log.e("UnsupportedEncodingException", e.getMessage());
		} catch (ClientProtocolException e){
			Log.e("ClientProtocolException", e.getMessage());
		} catch (IOException e) {
			Log.e("I/O", e.getMessage());
		}
		
		try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            requestResult = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
		return requestResult;
	}
	
}
