package com.example.space.master;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class SpaceView extends GLSurfaceView implements SensorEventListener{

	SpaceRenderer levelZeroRenderer;
	SensorManager mSensorManager;
	Sensor mAccelerometer;
	float xOldValue;

	public SpaceView(Context context) {
		super(context);
        xOldValue = 10;
		mSensorManager = (SensorManager) context.getSystemService(context.SENSOR_SERVICE);
		mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        levelZeroRenderer = new SpaceRenderer(context);
		setRenderer(levelZeroRenderer);
		// TODO Auto-generated constructor stub
	}

	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onSensorChanged(SensorEvent sensorEvent) {
		// TODO Auto-generated method stub
		
		float xNewValue = sensorEvent.values[0]+10;
		levelZeroRenderer.rotateShip((xNewValue - xOldValue));
		levelZeroRenderer.moveShip(-(xNewValue - xOldValue)/100, 0f, 0f);
		
	}

	public void registerAccelerometer() {
		   
		mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME);
		     
	}

	public void unregisterAccelerometer() {
		   
		mSensorManager.unregisterListener(this);
	    	     
	}

	public boolean onTouchEvent(final MotionEvent event) {
	    
		System.out.println("INNN***********");
		levelZeroRenderer.fireLaserBeam();
		// TODO Auto-generated method stub
		return false;
	}
	
}
