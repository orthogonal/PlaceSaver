/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MobiTech.PlaceSaver;

import android.os.Binder;
import android.os.IBinder;

import android.app.Service;
import android.content.Intent;
import android.location.*;

/**
 *
 * @author Will
 */
public class LocationService extends Service {

    //1 second in milliseconds
    public static int TIME_INTERVAL = 1000;
    //LocationManager for the entire class.
    LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
    //Global locatino provider.
    LocationProvider locationProvider = locationManager.GPS_PROVIDER;
    //Global Location state.
    public static Location bestEstimate = new Location(locationProvider);

    Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
    
    // Define a listener that responds to location updates.
    LocationListener locationListener = new LocationListener()
    {
        public void onLocationChanged(Location location)
        {
            // Called when a new location is found by the network location provider.
            makeUseOfNewLocation(location);
        }

        public void onStatusChanged(String provider, int status, Bundle extras)
        {
        }

        public void onProviderEnabled(String provider) 
        {
        }

        public void onProviderDisabled(String provider) 
        {
        }
    };
    
    /** Called when the service is created. **/
    @Override
    public void onCreate() {        
    }

    /** Called when the service is started. **/
    @Override
    public int onStartCommand(Intent intent, int flags, int startID)
    {
        return START_STICKY;
    }

    /** Called when the service is destroyed. **/
    @Override
    public void onDestroy()
    {
        //cancel everything
    }
    
    public IBinder onBind(Intent intent)
    {
        return new Binder();
    }
    
    protected boolean isBetterLocation(Location currentBest, Location update)
    {
        //if we don't have an old Location, let's take the new one.
        if(currentBest == null)
        {
            return true;
        }
        
        //is the new Location significantly more recent?
        boolean isNewer = (update.getTime() - currentBest.getTime()) >= TIME_INTERVAL/2;
        
        //is the new Location significantly more accurate?
        boolean isMoreAccurate = (update.getAccuracy() - currentBest.getTime()) >= 5;
        
        return isNewer && isMoreAccurate;
    }
    /**
     * Location CURRENT_LOCATION;
     * 
     * define LocationListener;
     * 
     * Location getLocation(){
     *      #THIS WILL ALWAYS HAVE THE BEST ESTIMATE
     *      return CURRENT_LOCATION;
     *      }
     * 
     * void updateLocation(){
     *      if(CURRENT_LOCATION is close enough to reminder){
     *          replace cell tower listener with gps listener
     *          }
     *      CURRENT_LOCATION = listener.get();
     *      }
     *      
     *      ()()()()()THIS PSUEDOCODE IS NOT COMPLETE()()()()()
     */
}
