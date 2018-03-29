package com.example.uchit.weatherforecast.model.data.network;

import com.example.uchit.weatherforecast.model.data.network.AppApiHelper;
import com.example.uchit.weatherforecast.model.data.network.IApiHelper;
import com.example.uchit.weatherforecast.model.data.network.IDataManager;
import com.example.uchit.weatherforecast.model.data.network.model.displayforecastbycity.ForecastModel;

import io.reactivex.Observable;

/**
 * Created by Uchit on 28/03/2018.
 */

public class AppDataManager implements IDataManager {

    private IApiHelper iApiHelper;

    public AppDataManager() {
        this.iApiHelper = new AppApiHelper();
    }

    @Override
    public Observable<ForecastModel> getForecasts() {
        return iApiHelper.getForecasts();
    }
}
