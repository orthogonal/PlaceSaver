package MobiTech.PlaceSaver;


import java.util.ArrayList;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

public class Maps1 extends MapActivity{ 

	private MapView mapView;
	/**A MapView is one interactive map.  So we declare this as an object of the entire class since it's going to be used
	 * in a lot of different methods in this MapActivity.
	 */
	
	private ArrayList<OverlayItem> locations = new ArrayList<OverlayItem>();
	/**locations is a collection of points.**/
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maps); 
		
		mapView = (MapView)findViewById(R.id.mapview);
		/**This line sets the handler for the MapView for the entire class, mapView equal to the displayed on the screen from the XML file.  **/
       
		Drawable marker = getResources().getDrawable(R.drawable.redflag);
		marker.setBounds((int)(-marker.getIntrinsicWidth()/2), -marker.getIntrinsicHeight(), (int)(marker.getIntrinsicWidth()/2), 0);
		/**These two lines set up the marker for use with an ItemizedOverlay.  
		 * The first one sets the Drawable object marker equal to the redflag in the res/drawable folder.
		 * The next one sets the (left, top, right, bottom) coordinates.  This is so that the Maps API knows where the (0, 0) point is.
		 * In this case, it's halfway across the bottom edge.  So the bottom-left corner is (half, 0) or the bottom point of the flagpole.
		 * super(boundCenterBottom(marker)); does the same thing.
		 */
		
		
		InterestingLocations funPlaces = new InterestingLocations(marker, this);
		mapView.getOverlays().add(funPlaces);
		/**This adds the overlay defined in the private class below.
		 * First, it instantiates the overlay.  This will call the constructor, which adds the two points in it.
		 * Then we add that overlay to the mapView so that it shows up.
		 */
		
		GeoPoint pt = new GeoPoint(38914887, -94640821);
		int latSpan = funPlaces.getLatSpanE6();
		int lonSpan = funPlaces.getLonSpanE6();
		
		MapController mc = mapView.getController();
		mc.setCenter(pt);
		mc.zoomToSpan((int)(latSpan*1.5), (int)(lonSpan*1.5));
		
	}
	
	/**The below section makes extensive use of mapView.getController(), which is used to zoom. **/
	/**It is also easy to change the view - there are just boolean methods for each view.  **/
	public void myClickHandler(View target) {
		switch(target.getId()) {
		case R.id.zoomin:
			mapView.getController().zoomIn();
			break;
		case R.id.zoomout:
			mapView.getController().zoomOut();
			break;
		case R.id.sat:
			mapView.setSatellite(true);
			break;
		case R.id.street:
			mapView.setStreetView(true);
			break;
		case R.id.traffic:
			mapView.setTraffic(true);
			break;
		case R.id.normal:
			mapView.setSatellite(false);
			mapView.setStreetView(false);
			mapView.setTraffic(false);
			break;
		}
		mapView.postInvalidateDelayed(2000);  //This is just one of those mysterious things that HAS to be there.
	}
	/**Addition of the below two methods is required by the Google Maps TOS.  That's the only reason they're here.  **/
	@Override
	protected boolean isLocationDisplayed() {
		return false;
	}	
	@Override
	protected boolean isRouteDisplayed(){
		return false;
	}
	
	class InterestingLocations extends ItemizedOverlay {
		/**The Overlay class itself defines the contract for an overlay, so you can't instantiate it.
		*ItemizedOverlay is an implementation that is oriented for the creation of new items in the manner we want.
		**/
		
		Context mContext;
		public InterestingLocations(Drawable marker, Context context){
			/**This is the constructor for this class.  It creates a couple points and then calls populate() to add them.  **/
			
			super(marker);
			
			mContext = context;
			
			GeoPoint point = new GeoPoint(38914887, -94640801);
			GeoPoint point2 = new GeoPoint(38914900, -94640821);
			
			locations.add(new OverlayItem(point, "Point 1", "Point 1"));
			locations.add(new OverlayItem(point2, "Point 2", "Point 2"));
			
			populate();
			/**populate() caches any OverlayItems.  It first calls the size() method to determine the number of items,
			*and then goes into a loop using that information to call createItem(i) for each item.  
			**/
		}
		
		/**This method adds a new item whenever anyone clicks on the map.  It's onTap so when they're just moving the map
		 * nothing happens.
		 */
		public boolean onTap(GeoPoint p, MapView mapView){
			if (super.onTap(p, mapView))
					return true;
			
			locations.add(new OverlayItem(p, "Point 3", "Point 3"));
			populate();
			return false;
		}
		
		
		@Override
		protected boolean onTap(int index) {
		  OverlayItem item = locations.get(index);
		  AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
		  dialog.setTitle(item.getTitle());
		  dialog.setMessage(item.getSnippet());
		  dialog.show();
		  return true;
		}
		
		@Override
		public void draw(Canvas canvas, MapView mapView, boolean shadow)
		{
			super.draw(canvas, mapView, shadow);
		}
		
		@Override
		protected OverlayItem createItem(int i) {
			return locations.get(i);
		}
		
		@Override
		public int size() {
			return locations.size();
		}
		
	}
	
	
}