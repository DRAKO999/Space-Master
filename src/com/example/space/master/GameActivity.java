package com.example.space.master;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GameActivity extends Activity {

	SpaceView spaceView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        spaceView = new SpaceView(getApplicationContext());
        setContentView(spaceView);
    }
    
}
