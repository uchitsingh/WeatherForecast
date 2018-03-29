package com.example.uchit.weatherforecast.model.data.network;

import com.example.uchit.weatherforecast.model.data.network.model.displayforecastbycity.ForecastModel;
import com.example.uchit.weatherforecast.model.data.network.service.IRequestInterface;
import com.example.uchit.weatherforecast.model.data.network.service.ServiceConnection;

import io.reactivex.Observable;

/**
 * Created by Uchit on 28/03/2018.
 */

public class AppApiHelper implements IApiHelper {

    private IRequestInterface iRequestInterface;
    public AppApiHelper() {
        iRequestInterface = ServiceConnection.getConnection();
    }

    @Override
    public Observable<ForecastModel> getForecasts() {
        return iRequestInterface.getForecasts();
    }
}
