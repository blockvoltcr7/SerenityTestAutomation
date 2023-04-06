package tests;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CircuitBreakerLoadTest2 {

    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        Runnable request = () -> {
            try {
                HttpGet httpGet = new HttpGet("https://api.restful-api.dev/objects");
                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity responseEntity = httpResponse.getEntity();
                String response = EntityUtils.toString(responseEntity);
                System.out.println(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        // Schedule the requests to run every second for 5 minutes
        executorService.scheduleAtFixedRate(request, 0, 1, TimeUnit.SECONDS);
        executorService.schedule(() -> executorService.shutdown(), 1, TimeUnit.MINUTES);
    }

}
