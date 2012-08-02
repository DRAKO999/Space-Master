package com.example.space.master;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class SpaceRenderer implements GLSurfaceView.Renderer {

	Context context;
	ShipHullModel shipHull;
	
	public SpaceRenderer(Context context) {
		
		this.context = context;
		this.shipHull = new ShipHullModel();
		
	}
	
	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub
		gl.glClearColor(0f, 0f, 0f, 1.0f);
		 
        // reset the matrix - good to fix the rotation to a static angle
        gl.glLoadIdentity();
 
        // clear the color buffer to show the ClearColor we called above...
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
 
		shipHull.drawShipHull(gl);
	}

	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		gl.glViewport(0, 0, width, height);
		
	}

	public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {
		// TODO Auto-generated method stub
			gl.glEnable(GL10.GL_CULL_FACE);
		    // which is the front? the one which is drawn counter clockwise
		    gl.glFrontFace(GL10.GL_CCW);
		    // which one should NOT be drawn
		    gl.glCullFace(GL10.GL_BACK);
		    
		    gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		    
		    shipHull.initShipHullModel();
		    
	    
	}

}
