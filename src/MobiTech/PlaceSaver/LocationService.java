/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MobiTech.PlaceSaver;

import android.os.Binder;
import android.os.IBinder;

import android.app.Service;
import android.content.Intent;

/**
 *
 * @author Will
 */
public class LocationService extends Service {

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
