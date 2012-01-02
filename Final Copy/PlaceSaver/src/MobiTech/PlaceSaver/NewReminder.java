package MobiTech.PlaceSaver;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class NewReminder extends Activity implements OnClickListener{

		@Override
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.newreminder);
			
			View saveButton = findViewById(R.id.new_save);
			View cancelButton = findViewById(R.id.new_cancel);
			
			saveButton.setOnClickListener(this);
			cancelButton.setOnClickListener(this);
		}
		
		public void onClick(View view){
			switch (view.getId()){
			case R.id.new_save:
				break;
			case R.id.new_cancel:
				finish();
				break;
			}
		}

}
