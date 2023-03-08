package fr.m2i.springbootinit;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class UserSecurity {

    private static final String URL = "https://emailvalidation.abstractapi.com/v1/?api_key=f3d064ba905b435db279d0fbe551aa2e&email=";

    protected static boolean checkEmail(String email) {
        HttpGet request = new HttpGet(URL + email);
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            JSONObject jsonObject = new JSONObject(client.execute(request, new BasicHttpClientResponseHandler()));
            JSONObject isValidEmail = (JSONObject) jsonObject.get("is_valid_format");
            return (boolean) isValidEmail.get("value");
        } catch (JSONException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
