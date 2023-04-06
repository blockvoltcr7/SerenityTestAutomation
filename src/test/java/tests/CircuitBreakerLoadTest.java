package tests;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CircuitBreakerLoadTest {

    public static void main(String[] args) {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> {
            try {
                HttpGet httpGet = new HttpGet("https://api.restful-api.dev/objects");
                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity responseEntity = httpResponse.getEntity();
                String response = EntityUtils.toString(responseEntity);
                System.out.println(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                HttpGet httpGet = new HttpGet("https://api.restful-api.dev/objects");
                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity responseEntity = httpResponse.getEntity();
                String response = EntityUtils.toString(responseEntity);
                System.out.println(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                HttpGet httpGet = new HttpGet("https://api.restful-api.dev/objects");
                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity responseEntity = httpResponse.getEntity();
                String response = EntityUtils.toString(responseEntity);
                System.out.println(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }

}
