package MobiTech.PlaceSaver;

import android.app.Activity;
import android.os.Bundle;
//import android.location.*;

/**
 * The main Map screen.
 * 
 * @author William B. Wettersten
 * @author Andrew C. Latham
 * 
 * @version 1.0
 */
public class MapActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState); //You should always call the super class before doing anything in these lifecycle methods ~Andrew
        setContentView(R.layout.main);		//This line calls the main.xml file located in res/layout/main.xml (R is the res folder)  ~Andrew
    }
}
