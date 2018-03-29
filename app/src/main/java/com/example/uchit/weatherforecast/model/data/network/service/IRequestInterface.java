package com.example.uchit.weatherforecast.model.data.network.service;

import com.example.uchit.weatherforecast.model.data.network.model.displayforecastbycity.ForecastModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Uchit on 28/03/2018.
 */

public interface IRequestInterface {

    @GET(ApiList.RELATIVE_URL_FORECAST_DETAIL)
    Observable<ForecastModel> getForecasts();


//    Observable<ForecastModel> getForecasts(@Query("q") String city, @Query("appid") String apiKey );

}
