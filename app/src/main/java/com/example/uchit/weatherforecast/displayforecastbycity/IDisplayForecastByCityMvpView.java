package com.example.uchit.weatherforecast.displayforecastbycity;

import com.example.uchit.weatherforecast.model.data.network.model.displayforecastbycity.ForecastModel;
import com.example.uchit.weatherforecast.ui.base.MvpView;

/**
 * Created by Uchit on 28/03/2018.
 */

public interface IDisplayForecastByCityMvpView extends MvpView {
    void onFetchDataProgress();
    void onFetchDataSuccess(ForecastModel forecastModel);
    void onFetchDataError(String error);


}
