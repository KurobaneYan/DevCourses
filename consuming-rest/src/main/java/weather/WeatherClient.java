package weather;

import hello.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.stream.StreamingPayload;

import java.text.SimpleDateFormat;

public class WeatherClient extends WebServiceGatewaySupport {
    public GetCityForecastByZIPResponse getCityForecastByZIP(String zipCode) {
        GetCityForecastByZIP request = new GetCityForecastByZIP();
        request.setZIP(zipCode);

        System.out.println("Requesting forecast for " + zipCode);

        GetCityForecastByZIPResponse response = (GetCityForecastByZIPResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "http://wsf.cdyne.com/WeatherWS/Weather.asmx",
                        request,
                        new SoapActionCallback("http://ws.cdyne.com/WeatherWS/GetCityForecastByZIP"));

        return response;
    }

    public void printResponse(GetCityForecastByZIPResponse response) {
        ForecastReturn forecastReturn = response.getGetCityForecastByZIPResult();

        if (forecastReturn.isSuccess()) {
            System.out.println("Forecast for " + forecastReturn.getCity());

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            for (Forecast forecast : forecastReturn.getForecastResult().getForecast()) {
                Temp temperature = forecast.getTemperatures();

                System.out.println(String.format("%s %s %s°-%s°", format.format(forecast.getDate().toGregorianCalendar().getTime()),
                        forecast.getDesciption(), temperature.getMorningLow(), temperature.getDaytimeHigh()));
                System.out.println("");
            }
        } else {
            System.out.println("No forecast received");
        }
    }
}
