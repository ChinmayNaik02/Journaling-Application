package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import net.engineeringdigest.journalApp.cache.AppCache;
import net.engineeringdigest.journalApp.constants.Placeholders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private String apiKey;

    @Autowired
    AppCache appCache;

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city) {
        String finalAPI = appCache.APP_CACHE.get(AppCache.keys.WEATHER_API.toString()).replace(Placeholders.CITY, city).replace(Placeholders.API_KEY, apiKey);
        ResponseEntity<WeatherResponse> exchange = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        return exchange.getBody();
    }


}
