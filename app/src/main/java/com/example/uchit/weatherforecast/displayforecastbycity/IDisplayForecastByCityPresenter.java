package com.example.uchit.weatherforecast.displayforecastbycity;

import com.example.uchit.weatherforecast.ui.base.MvpPresenter;

/**
 * Created by Uchit on 28/03/2018.
 */

public interface IDisplayForecastByCityPresenter  <V extends IDisplayForecastByCityMvpView> extends MvpPresenter<V> {
    void loadForecast();
}
