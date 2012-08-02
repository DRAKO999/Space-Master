package com.example.space.master;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class SpaceRenderer implements GLSurfaceView.Renderer {

	Context context;
	SpaceShipModel starShip;
	SpaceShipModel enemyShip;
	public SpaceRenderer(Context context) {
		
		this.context = context;
		starShip = new SpaceShipModel();
		enemyShip = new SpaceShipModel();
		
	}
	
	public void onDrawFrame(GL10 gl) {
		
	    gl.glClearColor(0f, 0f, 0f, 1.0f);
	    gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	 
	    starShip.drawSpaceShipMode(gl);
		enemyShip.drawSpaceShipMode(gl);
	    
	}

	public void moveShips() {

		enemyShip.setPosition(-0.01f, 0f, 0f);
		starShip.setRotationAngle(5);
		
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
		    gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		 
		    starShip.initSpaceShipModel();
		    enemyShip.initSpaceShipModel();
			starShip.setRotationVector(0f, 0.2f, 1f);
			starShip.setPosition(0f, 0f, 0f);
			
	}

}
