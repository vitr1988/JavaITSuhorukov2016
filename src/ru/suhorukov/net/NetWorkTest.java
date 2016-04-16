package ru.suhorukov.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class NetWorkTest {

	public static void main(String[] args) {
		
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address.getHostName() + " : " + address.getHostAddress());
			
//			InetAddress otherAddress = InetAddress.getByName("test");
			
			URI uri = new URI("http://ya.ru:80/test.txt");
			System.out.println(uri.getScheme() + ";" + uri.getHost() + ";" + uri.getPort() + uri.getPath());
			
			URL javaCourseURL = new URL("http://suhorukov.com/courses/junior-java-developer-online");
//			try (BufferedReader reader = new BufferedReader(new InputStreamReader(javaCourseURL.openStream()))){
//			try (BufferedReader reader = new BufferedReader(new InputStreamReader(javaCourseURL.openConnection().getInputStream()))){
//				String line = "";
//				while((line = reader.readLine()) != null){
//					System.out.println(line);
//				}
//			}
			URLConnection connection = javaCourseURL.openConnection();
			String str = "param1=" + URLEncoder.encode("мама мыла раму", "UTF-8")
				+ "&param2=afgdgfg";
			connection.addRequestProperty("CustomHeader", "CustomHeader");
			connection.setDoOutput(true);
			
			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(str.getBytes());
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
				String line = "";
				while((line = reader.readLine()) != null){
					System.out.println(line);
				}
			}
			System.out.println("-------------");
			System.out.println(connection.getContentType());
			System.out.println(connection.getContentEncoding());
			outputStream.close();
			
			
			//---
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet("http://ya.ru");
			CloseableHttpResponse response1 = httpclient.execute(httpGet);
			// The underlying HTTP connection is still held by the response object
			// to allow the response content to be streamed directly from the network socket.
			// In order to ensure correct deallocation of system resources
			// the user MUST call CloseableHttpResponse#close() from a finally clause.
			// Please note that if response content is not fully consumed the underlying
			// connection cannot be safely re-used and will be shut down and discarded
			// by the connection manager. 
			try {
			    System.out.println(response1.getStatusLine());
			    HttpEntity entity1 = response1.getEntity();
			    // do something useful with the response body
			    // and ensure it is fully consumed
			    EntityUtils.consume(entity1);
			} finally {
			    response1.close();
			}

			HttpPost httpPost = new HttpPost("http://ya.ru");
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("username", "vip"));
			nvps.add(new BasicNameValuePair("password", "secret"));
			httpPost.setEntity(new UrlEncodedFormEntity(nvps));
			CloseableHttpResponse response2 = httpclient.execute(httpPost);

			try {
			    System.out.println(response2.getStatusLine());
			    HttpEntity entity2 = response2.getEntity();
			    // do something useful with the response body
			    // and ensure it is fully consumed
			    EntityUtils.consume(entity2);
			} finally {
			    response2.close();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
