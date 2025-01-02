package models;

import java.util.Map;

public record ExchangeRateRespuesta(
        String result,
        String base_code,
        Map<String, Double> conversion_rates
) { }
