package com.example.space.master;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

public class GameActivity extends Activity {

	SpaceView spaceView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        spaceView = new SpaceView(getApplicationContext());
        
        setContentView(spaceView);
    
    }
    
	
	@Override
	public void onResume()
    {
        super.onResume();
        // Register this class as a listener for the accelerometer sensor
        spaceView.registerAccelerometer();
        // ...and the orientation sensor
     
    }

    @Override
    public void onStop()
    {
    	super.onStop();
        spaceView.unregisterAccelerometer();
    
    }

}
