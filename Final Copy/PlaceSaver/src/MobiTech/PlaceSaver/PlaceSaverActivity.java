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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class PlaceSaverActivity extends MapActivity{ 

	private MapView theMap;
	/**A MapView is one interactive map.  So we declare this as an object of the entire class since it's going to be used
	 * in a lot of different methods in this MapActivity.
	 */
	
	private ArrayList<OverlayItem> flags = new ArrayList<OverlayItem>();
	/**locations is a collection of points.**/
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		theMap = (MapView)findViewById(R.id.mapview);
		/**This line sets the handler for the MapView for the entire class, mapView equal to the displayed on the screen from the XML file.  **/
		
		theMap.displayZoomControls(true);
		//** Enable the zoom at the bottom of the screen **/
       
		Drawable flagPic = getResources().getDrawable(R.drawable.redflag);
		flagPic.setBounds((int)(-flagPic.getIntrinsicWidth()/2), -flagPic.getIntrinsicHeight(), (int)(flagPic.getIntrinsicWidth()/2), 0);
		/**These two lines set up the flag for use with an ItemizedOverlay.  
		 * The first one sets the Drawable object marker equal to the redflag in the res/drawable folder.
		 * The next one sets the (left, top, right, bottom) coordinates.  This is so that the Maps API knows where the (0, 0) point is.
		 * In this case, it's halfway across the bottom edge.  So the bottom-left corner is (half, 0) or the bottom point of the flagpole.
		 */
		
		
		flagLayer layer = new flagLayer(flagPic, this);
		theMap.getOverlays().add(layer);
		/**This adds the overlay defined in the private class below.
		 * First, it instantiates the overlay.  This will call the constructor, which adds the two points in it.
		 * Then we add that overlay to the mapView so that it shows up.
		 */
		
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
	
	class flagLayer extends ItemizedOverlay {
		/**The Overlay class itself defines the contract for an overlay, so you can't instantiate it.
		*ItemizedOverlay is an implementation that is oriented for the creation of new items in the manner we want.
		**/
		
		Context context;
		public flagLayer(Drawable flagPic, Context c){
			/**This is the constructor for this class.  It creates a couple points and then calls populate() to add them.  **/		
			super(flagPic);
			context = c;
			
			//THERE NEEDS TO BE SOMETHING HERE TO GET THE CURRENT OVERLAY ITEMS FROM A DATABASE
			//locations.add(new OverlayItem(point, "Point 1", "Point 1"));
			
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
			
			flags.add(new OverlayItem(p, "Point 3", "Point 3"));
			populate();
			return false;
		}
		@Override
		protected boolean onTap(int index) {
		  OverlayItem item = flags.get(index);
		  AlertDialog.Builder dialog = new AlertDialog.Builder(context);
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
			return flags.get(i);
		}
				@Override
		public int size() {
			return flags.size();
		}
	}	

	@Override
	public boolean onCreateOptionsMenu(Menu menu1) {
		super.onCreateOptionsMenu(menu1);
		MenuInflater x = getMenuInflater();
		x.inflate(R.menu.mapmenu, menu1);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected (MenuItem item1) {
		super.onOptionsItemSelected(item1);
		switch (item1.getOrder()){
		case 1:
			break;
		case 2:
			theMap.setSatellite(false);
			break;
		case 3:
			theMap.setSatellite(true);
			break;
		}
		return true;
	}

	
}