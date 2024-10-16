package org.example.api;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.example.model.CurrencyResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExchangeRateApi {
    private static final String API_KEY = "6d0280b9c4239b74dc86af64";
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

    public double obterTaxaDeCambio(String moedaBase, String moedaAlvo) {
        try {
            URL url = new URL(API_URL + moedaBase);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
            connection.connect();

            if (connection.getResponseCode() != 200) {
                throw new IOException("Erro ao obter dados da API: " + connection.getResponseCode());
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }

            reader.close();

            Gson gson = new Gson();
            CurrencyResponse currencyResponse = gson.fromJson(responseBuilder.toString(), CurrencyResponse.class);
            return currencyResponse.getRates().get(moedaAlvo);
        } catch (IOException | JsonSyntaxException e) {
            System.out.println("Erro ao obter dados da API: " + e.getMessage());
            return 0.0; // Retorna 0 em caso de erro
        }
    }
}
