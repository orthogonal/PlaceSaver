package MobiTech.PlaceSaver;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class OldReminder extends Activity implements OnClickListener{
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.oldreminder);
		
		View saveButton = findViewById(R.id.old_save);
		View cancelButton = findViewById(R.id.old_cancel);
		
		saveButton.setOnClickListener(this);
		cancelButton.setOnClickListener(this);
	}
	
	public void onClick(View view){
		switch (view.getId()){
		case R.id.old_save:
			break;
		case R.id.old_cancel:
			finish();
			break;
		}
	}

}
