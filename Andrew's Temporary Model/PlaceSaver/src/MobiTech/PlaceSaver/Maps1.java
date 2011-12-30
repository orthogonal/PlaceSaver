package MobiTech.PlaceSaver;

import android.app.Activity;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

import android.os.Bundle;

public class Maps1 extends MapActivity { 

	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maps);
	}
	
	@Override
	protected boolean isRouteDisplayed(){
		return false;
	}
}