package MobiTech.PlaceSaver;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class FlaggedLocation extends ItemizedOverlay {

	private ArrayList<OverlayItem> flags = new ArrayList<OverlayItem>();	//Array list of flags on the map
	Context mContext;														//Context is the current state of the system.  This is an empty variable you can pass to.
	
	public FlaggedLocation(Drawable defaultFlag) {
		super(boundCenterBottom(defaultFlag));
	}
	public FlaggedLocation(Drawable defaultFlag, Context now){
		super(boundCenterBottom(defaultFlag));
		mContext = now;
	}
	/** These are the constructors.  One of them takes a context as an argument, the other does not.  The superclass call draws the flag onto the map.  **/
	
	
	public void add(OverlayItem newFlag){
		flags.add(newFlag);
		populate();
	}
	@Override
	protected OverlayItem createItem(int i){
		return flags.get(i);
	}
	@Override
	public int size(){
		return flags.size();
	}
	/** The bottom two methods must both be overridden to work with ArrayList.  populate() calls the first, and the other is just used in general. **/
	
	@Override
	protected boolean onTap(int index){ 
		OverlayItem item = flags.get(index);
		AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
		dialog.setTitle(item.getTitle());
		dialog.setMessage(item.getSnippet());
		dialog.show();
		return true;
	}
	/**When a FlaggedLocation is tapped, this is what happens.  First, it gets the flag with that index from the flags ArrayList.
	 * Then it creates a dialog using the Context from it.  
	 * Finally, it returns true.  **/
	 

}
