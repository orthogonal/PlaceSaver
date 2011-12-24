package MobiTech.PlaceSaver;

import android.app.Activity;
import android.os.Bundle;
import android.location.*;

/**
 * The main Map screen.
 * 
 * @author William B. Wettersten
 * @author Andrew Latham
 * 
 * @version 1.0
 */
public class MapActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
