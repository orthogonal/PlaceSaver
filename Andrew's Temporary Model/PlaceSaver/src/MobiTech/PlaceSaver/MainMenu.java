package MobiTech.PlaceSaver;

import android.app.Activity;				//Required to make new activities (obviously required)
import android.os.Bundle;					//The Bundle handles the information that was saved the last time the app paused/stopped.
import android.content.Intent;				//Required to make an intent
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.View;					//So you can manipulate the graphics
import android.view.View.OnClickListener;	//Required to make click events


public class MainMenu extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); //R is the "res" folder.  res/layout/main.xml is the XML file describing the display.
        
        /**  The lines below are used to assign identifying variables to form elements on the main menu.
        *  The syntax for doing this is similar to JavaScript: give the elements IDs and use those IDs to select them.
        *  The IDs for these particular objects are assigned in the layoung.main.xml file **/
        View oldButton = findViewById(R.id.mainOldButton);
        View newButton = findViewById(R.id.mainNewButton);
        View helpButton = findViewById(R.id.mainHelpButton);
        View aboutButton = findViewById(R.id.mainAboutButton);
        
        /**  The next four lines are Java syntax to create click events for the elements identified above **/
        oldButton.setOnClickListener(this);
        newButton.setOnClickListener(this);
        helpButton.setOnClickListener(this);
        aboutButton.setOnClickListener(this);
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu m){
		super.onCreateOptionsMenu(m);
		MenuInflater x = getMenuInflater();
		x.inflate(R.menu.backmenu, m);
		m.findItem(R.id.do_nothing).setIntent(new Intent(this, Nothing.class));
		return true;
	}
 /** The above is what happens when the "Menu" button on the Android is pressed.  First, call the super class.
  * Then make an inflater to bring the menu up.  We inflate "backmenu" here, the menu defined in res/menu/backmenu.xml
  * Note that I had to make the res/menu folder myself.  Then you set intents for each item on the menu.  Items are linked to
  * via their id.  Finally, it's a boolean method (for some odd reason) so you have to return true.  More below...
  */
    
	
	@Override
	public boolean onOptionsItemSelected(MenuItem x){
		super.onOptionsItemSelected(x);
		startActivity(x.getIntent());
		return true;
	}
	
	/** This method goes hand-in-hand with the onCreateOptionsMenu menu.  The item in the menu that you select is passed as an argument.
	 * Then you call the superclass first (as always), and then simply startActivity with the intent defined in the 
	 * onCreateOptionsMenu class above.  There really isn't much to see here.
	 */
    
    public void onClick(View thisView) {
    /**Called when something is clicked in this activity (I think) this checks the ID of what was clicked and does something.**/
    	switch (thisView.getId()) {
    	case R.id.mainOldButton:
    		Intent go2Old = new Intent(this, OldReminders.class);
    		startActivity(go2Old);
    		break;
    	case R.id.mainNewButton:
    		Intent go2New = new Intent(this, NewReminder.class);
    		startActivity(go2New);
    		break;
    	case R.id.mainHelpButton:
    		Intent go2Help = new Intent(this, Help.class);
    		startActivity(go2Help);
    		break;
    	case R.id.mainAboutButton:
    		Intent go2About = new Intent(this, About.class);
    		startActivity(go2About);
    		break;
    	}
    }
    
    
}