package csc214.project3;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by leew15 on 4/22/2017.
 */

public class DailyWeather extends AsyncTask<String, Void, String> {

    public static ArrayList<Weather> mList;
    private IntroActivity activity;

    public DailyWeather(IntroActivity activity){
        this.activity = activity;
        mList = new ArrayList<>();
    }
    @Override
    protected String doInBackground(String... urls) {
        String result = "";
        URL url;
        HttpURLConnection urlConnection = null;

        // gets data from url until -1 using while loop
        try {
            url = new URL(urls[0]);

            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream is = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);

            int data = reader.read();

            while (data != -1) {
                char current = (char) data;
                result += current;
                data = reader.read();
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        // get weather conditions of all day weather
        try {
            JSONObject forecastJson = new JSONObject(result);
            JSONArray forecastArray = forecastJson.getJSONArray("list");
            // get daily low and high
            JSONObject dailyForecast = forecastArray.getJSONObject(0);
            JSONObject tempObject = dailyForecast.getJSONObject("temp");

            JSONArray weatherObject = dailyForecast.getJSONArray("weather");
            JSONObject weather = weatherObject.getJSONObject(0);

            double windSpeed = dailyForecast.getDouble("speed");
            double min = tempObject.getDouble("min");
            double max = tempObject.getDouble("max");
            IntroActivity.mCondition = weather.getString("main");

            // change double temp to fahrenheit temperature
            int minTemp = (int) (min * 1.8 - 459.67);
            int maxTemp = (int) (max * 1.8 - 459.67);

            IntroActivity.mLowTemp = minTemp;
            IntroActivity.mHighTemp = maxTemp;

            System.out.println("Today's High is " + String.valueOf(maxTemp));
            System.out.println("Today's Low is " + String.valueOf(minTemp));
            System.out.println("Today it is going to be " + IntroActivity.mCondition);

            // loop to put weather aspects in a list
            for (int i = 0; i < 5; i++){
                JSONObject forecastJson2 = new JSONObject(result);
                JSONArray forecastArray2 = forecastJson2.getJSONArray("list");
                // get daily low and high
                JSONObject dailyForecast2 = forecastArray2.getJSONObject(i);
                JSONObject tempObject2 = dailyForecast2.getJSONObject("temp");

                JSONArray weatherObject2 = dailyForecast2.getJSONArray("weather");
                JSONObject weather2 = weatherObject2.getJSONObject(0);

                double min2 = tempObject2.getDouble("min");
                double max2 = tempObject2.getDouble("max");

                // change double temp to fahrenheit temperature
                int minTemp2 = (int) (min2 * 1.8 - 459.67);
                int maxTemp2 = (int) (max2 * 1.8 - 459.67);
                String condition = weather2.getString("main");

                Weather w = new Weather(condition, minTemp2, maxTemp2);
                mList.add(w);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        activity.startFragment();
    }


}