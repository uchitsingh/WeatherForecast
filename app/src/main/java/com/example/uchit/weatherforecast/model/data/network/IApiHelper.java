package com.example.uchit.weatherforecast.model.data.network;

import com.example.uchit.weatherforecast.model.data.network.model.displayforecastbycity.ForecastModel;

import io.reactivex.Observable;

/**
 * Created by Uchit on 28/03/2018.
 */

public interface IApiHelper {
    Observable<ForecastModel> getForecasts();
}
