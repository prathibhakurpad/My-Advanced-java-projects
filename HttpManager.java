package Webcontent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class HttpManager  {
	
	public String ReadData(String url) throws IOException{
		
	CloseableHttpClient httpclient = HttpClients.createDefault();
	HttpGet httpGet = new HttpGet(url);
	CloseableHttpResponse response1 = httpclient.execute(httpGet);
	
	try {
	    System.out.println(response1.getStatusLine());
	    HttpEntity entity1 = response1.getEntity();
	    InputStream d1=entity1.getContent();
	    InputStreamReader input = new InputStreamReader(d1);
	    BufferedReader line = new BufferedReader(input);
	    String l1;
	   
	    StringBuilder data = new StringBuilder();
	    while( (l1=line.readLine()) != null){
	    
	   // data.append(line +"\n");
	    data.append(l1 +"\n");
	  
	    }
	   return data.toString();
	} finally {
	    response1.close();
	}
	
	}
}
