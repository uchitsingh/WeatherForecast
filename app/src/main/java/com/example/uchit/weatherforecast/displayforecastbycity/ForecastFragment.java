package com.example.uchit.weatherforecast.displayforecastbycity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.uchit.weatherforecast.R;
import com.example.uchit.weatherforecast.model.data.network.AppDataManager;
import com.example.uchit.weatherforecast.model.data.network.model.displayforecastbycity.ForecastModel;
import com.example.uchit.weatherforecast.model.data.network.service.IRequestInterface;
import com.example.uchit.weatherforecast.model.data.network.service.ServiceConnection;
import com.example.uchit.weatherforecast.ui.base.BaseFragment;
import com.example.uchit.weatherforecast.ui.utils.rx.AppSchedulerProvider;

import butterknife.BindView;
import io.reactivex.disposables.CompositeDisposable;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment  extends BaseFragment implements IDisplayForecastByCityMvpView{


    @BindView(R.id.rv_forecast) RecyclerView recyclerView;
    @BindView(R.id.tv_city_title)
    TextView m_City_Title;

    private DisplayForecastByCityPresenterIml<ForecastFragment> displayForecastByCityPresenterIml;

    //TextView textView;

    public ForecastFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        displayForecastByCityPresenterIml = new DisplayForecastByCityPresenterIml<>(new AppDataManager(), new AppSchedulerProvider(), new CompositeDisposable());
        displayForecastByCityPresenterIml.onAttach(this);
        return inflater.inflate(R.layout.fragment_forecast, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

/*        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiList.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())// adds gson converter
                .build();
        iRequestInterface = retrofit.create(IRequestInterface.class);*/


        initRecycleView();
        displayForecasts();

    }


    public void displayForecasts(){
/*        String apiKey = "dbaa93d47e28d3747fba4615e7ca9d0f";
        String city ="california";*/

/*        iRequestInterface.getForecasts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ForecastModel>() {
                    @Override
                    public void accept(ForecastModel forecastModel) throws Exception {
                        Toast.makeText(getContext(),"" + forecastModel.getCod(), Toast.LENGTH_SHORT).show();
                        Log.i("forecaster",  forecastModel.getCod() + " " + forecastModel.getList().get(0).getDtTxt());
                        recyclerView.setAdapter(new ForecastAdapter(forecastModel));


                  *//*      Toast.makeText(getContext(), forecastModel.getCnt(), Toast.LENGTH_SHORT).show();
                        Log.i("forecaster",forecastModel.getCnt().toString());*//*
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(getContext(),throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.i("forecasterError", throwable.getMessage());
                    }
                });*/
        displayForecastByCityPresenterIml.loadForecast();

    }

    private void initRecycleView() {
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity() , LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onFetchDataProgress() {
        showLoading();
    }

    @Override
    public void onFetchDataSuccess(ForecastModel forecastModel) {
        recyclerView.setAdapter(new ForecastAdapter(forecastModel));
        m_City_Title.setText(forecastModel.getCity().getName() + ", " + forecastModel.getCity().getCountry());
        hideLoading();
    }

    @Override
    public void onFetchDataError(String error) {
        showMessage(error);
        hideLoading();
    }
}
