package MobiTech.PlaceSaver;

import java.util.List;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.MapView.LayoutParams;  
import android.view.View;
import android.widget.LinearLayout;

import android.os.Bundle;

public class Maps1 extends MapActivity { 

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maps);
		
		MapView mapView = (MapView) findViewById(R.id.mapView);
        mapView.setBuiltInZoomControls(true);
        
        
        List<Overlay> flags = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.redflag); 
        FlaggedLocation flagloc = new FlaggedLocation(drawable, this);
       
        
        GeoPoint point = new GeoPoint(38914887, -94640801);
        OverlayItem overlayitem = new OverlayItem(point, "Where I am", "Starbucks in Barnes and Noble");
        //This defines a new overlay item at the point specified there.  
        //Note that points are specified in degrees x 10^6.
        //The two strings are the title and the snippet text for that item.
        
        flagloc.add(overlayitem);
        flags.add(flagloc);
        //Adds it to the collection.
	}
	
	@Override
	protected boolean isRouteDisplayed(){
		return false;
	}
}