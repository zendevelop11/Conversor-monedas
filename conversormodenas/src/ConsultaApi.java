import com.google.gson.Gson;
import models.ExchangeRateRespuesta;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConsultaApi {
    public ExchangeRateRespuesta buscaValor(String codigo){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/bd177799bebeb0ff5be9009c/latest/"+codigo);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ExchangeRateRespuesta.class);
        } catch (Exception e) {
            throw new RuntimeException("Codigo incorrecto.");
        }
    }

    public String obtenerListaCodigos(Map<String, Double> conversionRates) {
        StringBuilder sb = new StringBuilder();
        sb.append("+----------+\n");
        sb.append("| Codigo   |\n");
        sb.append("+----------+\n");

        for (String codigo : conversionRates.keySet()) {
            sb.append(String.format("| %-8s |\n", codigo));
        }

        sb.append("+----------+");
        return sb.toString();
    }
}
