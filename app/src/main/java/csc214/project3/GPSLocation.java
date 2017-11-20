package csc214.project3;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by leew15 on 4/22/2017.
 */

public class GPSLocation implements LocationListener{

    @Override
    public void onLocationChanged(Location location) {
        Log.e("Latitude :", "" + location.getLatitude());
        Log.e("Longitude :", "" + location.getLongitude());

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
