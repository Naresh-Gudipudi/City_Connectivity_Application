package com.example.demo;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ReachableApplicationTests {
/*
	@Test
	public void ApplicationTest1() throws URISyntaxException 
	{
		PopulateEntries pEntries = new PopulateEntries();
		pEntries.populateEntries();
		
		
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:8080/connected?origin=Trenton&destination=Newark";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("no"));
	}
*/
	
	@Test
	public void routeDoesnotExistBetweenCities()
	  throws ClientProtocolException, IOException {
	 
	    // Create Request
	    HttpUriRequest request = new HttpGet( "http://localhost:8080/connected?origin=Trenton&destination=Newark" );
	 
	    // Get Http Response
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Validate against status codes
	    
	    
	    Assert.assertEquals(200, httpResponse.getStatusLine().getStatusCode());
	}
	
	@Test
	public void routeExistsBetweenCities()
	  throws ClientProtocolException, IOException {
	 
	    // Create Request
	    HttpUriRequest request = new HttpGet( "http://localhost:8080/connected?origin=Boston&destination=Newark" );
	 
	    // Get Http Response
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Validate against status codes
	    
	    
	    Assert.assertEquals(200, httpResponse.getStatusLine().getStatusCode());
	}
	
	@Test
	public void invalidOriginCity()
	  throws ClientProtocolException, IOException {
	 
	    // Create Request
	    HttpUriRequest request = new HttpGet( "http://localhost:8080/connected?origin=abcde&destination=Newark" );
	 
	    // Get Http Response
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Validate against status codes
	    Assert.assertEquals(500, httpResponse.getStatusLine().getStatusCode());
	}
	
	@Test
	public void invalidDestinationCity()
	  throws ClientProtocolException, IOException {
	 
	    // Create Request
	    HttpUriRequest request = new HttpGet( "http://localhost:8080/connected?origin=Newark&destination=xyzabc" );
	 
	    // Get Http Response
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Validate against status codes
	    Assert.assertEquals(500, httpResponse.getStatusLine().getStatusCode());
	}
	
	@Test
	public void emptyOriginCity()
	  throws ClientProtocolException, IOException {
	 
	    // Create Request
	    HttpUriRequest request = new HttpGet( "http://localhost:8080/connected?origin=&destination=Newark" );
	 
	    // Get Http Response
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Validate against status codes
	    Assert.assertEquals(400, httpResponse.getStatusLine().getStatusCode());
	}
	
	@Test
	public void emptyDestinationCity()
	  throws ClientProtocolException, IOException {
	 
	    // Create Request
	    HttpUriRequest request = new HttpGet( "http://localhost:8080/connected?origin=Newark&destination=" );
	 
	    // Get Http Response
	    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	    // Validate against status codes
	    Assert.assertEquals(400, httpResponse.getStatusLine().getStatusCode());
	}
}
