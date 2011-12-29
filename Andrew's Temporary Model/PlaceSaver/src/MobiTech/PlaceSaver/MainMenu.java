package MobiTech.PlaceSaver;

import android.app.Activity;				//Required to make new activities (obviously required)
import android.os.Bundle;					//The Bundle handles the information that was saved the last time the app paused/stopped.
import android.content.Intent;				//Required to make an intent
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