package csc214.project3;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by leew15 on 4/22/2017.
 */

public class CurrentWeather extends AsyncTask<String, Void, String> {
    public static int mCurrentTemp;
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

            while (data != -1){
                char current = (char) data;
                result += current;
                data = reader.read();
            }
            return result;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(String result){
        super.onPostExecute(result);
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject weatherData = new JSONObject(jsonObject.getString("main"));

            double currentTemp = Double.parseDouble(weatherData.getString("temp"));
            double min = Double.parseDouble(weatherData.getString("temp_min"));
            double max = Double.parseDouble(weatherData.getString("temp_max"));

            // change double temp to fahrenheit temperature
            int currTemp = (int)(currentTemp * 1.8 - 459.67);

            mCurrentTemp = currTemp;
            System.out.println("Current Temperature is " + currTemp);

        } catch (Exception e){
            e.printStackTrace();
        }









    }
}
