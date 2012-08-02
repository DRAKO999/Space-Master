package com.example.space.master;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

public class SpaceView extends GLSurfaceView{

	SpaceRenderer levelZeroRenderer;
	MetalSheetPolygon shipHull;
	public SpaceView(Context context) {
		super(context);
		shipHull = new MetalSheetPolygon();
		levelZeroRenderer = new SpaceRenderer(context);
		setRenderer(levelZeroRenderer);
		// TODO Auto-generated constructor stub
	}
	
	public boolean onTouchEvent(final MotionEvent event) {

		shipHull.setRotationAngle(10);
		
		return true;
	}

}
