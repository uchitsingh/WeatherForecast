package com.example.uchit.weatherforecast.displayforecastbycity;

import com.example.uchit.weatherforecast.model.data.network.IDataManager;
import com.example.uchit.weatherforecast.model.data.network.model.displayforecastbycity.ForecastModel;
import com.example.uchit.weatherforecast.ui.base.BasePresenter;
import com.example.uchit.weatherforecast.ui.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Uchit on 28/03/2018.
 */

public class DisplayForecastByCityPresenterIml  <V extends IDisplayForecastByCityMvpView> extends BasePresenter<V> implements IDisplayForecastByCityPresenter<V>{


    public DisplayForecastByCityPresenterIml(IDataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void loadForecast() {
        getCompositeDisposable().add(getDataManager().getForecasts()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<ForecastModel>() {
                    @Override
                    public void accept(ForecastModel forecastModel) throws Exception {

                        getMvpView().onFetchDataSuccess(forecastModel);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getMvpView().onFetchDataError(throwable.getMessage());
                    }
                }));
              getMvpView().onFetchDataProgress();

    }
}
