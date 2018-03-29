package com.example.uchit.weatherforecast.displayforecastbycity;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uchit.weatherforecast.MyApp;
import com.example.uchit.weatherforecast.R;
import com.example.uchit.weatherforecast.model.data.network.model.displayforecastbycity.ForecastModel;
import com.squareup.picasso.Picasso;

/**
 * Created by Uchit on 28/03/2018.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {

    private ForecastModel forecastModel;

    public ForecastAdapter(ForecastModel forecastModel) {
        this.forecastModel = forecastModel;
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ForecastViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_forecast, parent, false));
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {
        holder.m_Date.setText(forecastModel.getList().get(position).getDtTxt());
        //main
        holder.m_temp_normal.setText(forecastModel.getList().get(position).getMain().getTemp().toString());
        holder.m_temp_max.setText(forecastModel.getList().get(position).getMain().getTempMax().toString());
        holder.m_temp_min.setText(forecastModel.getList().get(position).getMain().getTempMin().toString());
        holder.m_temp_pressure.setText(forecastModel.getList().get(position).getMain().getPressure().toString());
        holder.m_temp_humidity.setText(forecastModel.getList().get(position).getMain().getHumidity().toString());


        holder.m_weather_main.setText(forecastModel.getList().get(position).getWeather().get(0).getMain());
        holder.m_weather_description.setText(forecastModel.getList().get(position).getWeather().get(0).getDescription());

        holder.m_wind_deg.setText(forecastModel.getList().get(position).getWind().getDeg().toString());
        holder.m_wind_speed.setText(forecastModel.getList().get(position).getWind().getSpeed().toString());
        try{
            if(forecastModel.getList().get(position).getRain().get3h().toString()!=null ){
                holder.m_rain_3h.setText(forecastModel.getList().get(position).getRain().get3h().toString());
            }else{
                holder.m_rain_3h.setText("N/A");
            }

        }catch(Exception ex){
         //   Toast.makeText(MyApp.getInstance().getAppContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
            Log.i("rain_log", ex.getMessage());
        }




        String icon_url ="https://openweathermap.org/img/w/" + forecastModel.getList().get(position).getWeather().get(0).getIcon() +".png";
        Log.i("icon_url", icon_url);

        Picasso.with(MyApp.getInstance().getAppContext()).load(icon_url)
                .resize(700, 700)
                .centerCrop()
                .into(holder.m__weather_icon);

    }

    @Override
    public int getItemCount() {
        return forecastModel.getList().size();
    }

    public class ForecastViewHolder extends RecyclerView.ViewHolder {

        private TextView m_Date, m_temp_normal, m_temp_min, m_temp_max, m_temp_pressure, m_temp_humidity, m_weather_main, m_weather_description, m_wind_speed, m_wind_deg, m_rain_3h;
        private ImageView m__weather_icon;
        public ForecastViewHolder(View itemView) {
            super(itemView);
            //date
            m_Date = (TextView) itemView.findViewById(R.id.tv_date);
            //temp
            m_temp_normal = (TextView) itemView.findViewById(R.id.tv_temp_normal);
            m_temp_max = (TextView) itemView.findViewById(R.id.tv_temp_max);
            m_temp_min = (TextView) itemView.findViewById(R.id.tv_temp_min);
            m_temp_pressure = (TextView) itemView.findViewById(R.id.tv_temp_pressure);
            m_temp_humidity = (TextView) itemView.findViewById(R.id.tv_temp_humidity);
            //weather
            m_weather_main = (TextView) itemView.findViewById(R.id.tv_weather_main);
            m_weather_description = (TextView) itemView.findViewById(R.id.tv_weather_description);

            //wind
            m_wind_speed = (TextView) itemView.findViewById(R.id.tv_wind_speed);
            m_wind_deg = (TextView) itemView.findViewById(R.id.tv_wind_deg);
            //rain
            m_rain_3h = (TextView) itemView.findViewById(R.id.tv_rain_3h);

            m__weather_icon = (ImageView) itemView.findViewById(R.id.iv_weather_icon);

        }
    }
}
