import com.fasterxml.jackson.databind.ObjectMapper;
import dto.DailyForecast;
import dto.WeatherResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Lesson_7 {

    public static void main( String[] args ) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=WsD0U8WG9HrzoxnQQDiCqUJXZPGpwBGM&language=ru-ru&metric=true")
                .build();

        Response response = client.newCall(request).execute();
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse weatherResponse = objectMapper.readValue(response.body().byteStream(), WeatherResponse.class);

        for(DailyForecast forecast : weatherResponse.getDailyForecasts()) {
            System.out.printf(
                    "Погода в Санкт-Петербурге на " + forecast.getDate() + "\n" +
                            forecast.getDay().getIconPhrase() + " температура в пределах от " +
                            forecast.getTemperature().getMinimum().getValue() +
                            " до " + forecast.getTemperature().getMaximum().getValue() +
                            " " + forecast.getTemperature().getMinimum().getUnit() + "\n\n"
            );      // <- Грустный смайлик ...
        }
    }
}
