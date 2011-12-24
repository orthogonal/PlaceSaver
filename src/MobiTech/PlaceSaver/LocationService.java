/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MobiTech.PlaceSaver;

import android.app.Service;
import android.os.Bundle;

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
    public void onStartCommand(Intent intent, int flags, int startID) {
        return START_STICKY;
    }

    /** Called when the service is destroyed. **/
    @Override
    public void onDestroy() {
        //cancel everything
    }
    private final mBinder  = new LocalBinder();

    /** Called when the service is binded **/
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
