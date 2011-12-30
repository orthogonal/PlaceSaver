package MobiTech.PlaceSaver;

import android.preference.PreferenceActivity;
import android.os.Bundle;

public class Options extends PreferenceActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.options);
	}

}