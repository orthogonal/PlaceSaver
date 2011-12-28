/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MobiTech.PlaceSaver;

import android.location.*;

/**
 *
 * @author Will
 */
public class Reminder
{
    Location location;
    //Reminder radius in meters
    double radius = 1.0;
    
    public Reminder(Location l)
    {
        location = l;
    }
    
    public Reminder(Location l, int r)
    {
        location = l;
        radius = r;
    }
    
    public boolean withinRange()
    {
        return distanceFromUser() <= radius;
    }
    
    public double distanceFromUser()
    {
        //convert two lat/long pairs into a scalar distance
    }
}
