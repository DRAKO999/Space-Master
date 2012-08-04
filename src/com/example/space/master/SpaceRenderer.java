package com.example.space.master;

import java.util.ArrayList;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class SpaceRenderer implements GLSurfaceView.Renderer {

	private Context context;
	private SpaceShipModel starShip;
	private ArrayList <LaserBeam> beam;
	private float width = 480f;
	private float height = 800f;
	
	public SpaceRenderer(Context context) {
		
		beam = new ArrayList<LaserBeam>();
		this.context = context;
		starShip = new SpaceShipModel();
		
		
	}
	
	public void onDrawFrame(GL10 gl) {

		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);	
	         
		starShip.drawSpaceShipModel(gl);
		for (int i = 0; i< beam.size(); i++) {
		
			beam.get(i).setPosition(0f, 0f, -0.05f);
			beam.get(i).drawLaserBeam(gl);
			System.out.println("drawbeam");
		}
	}

	public void moveShip(float posX, float posY, float posZ) {
		
		starShip.setPosition(posX, posY, posZ);
		
	}
	
	public void fireLaserBeam() {
		
		LaserBeam newBeam = new LaserBeam();
		newBeam.initLaserBeam();
		newBeam.setPosition(starShip.getPosition()[0],starShip.getPosition()[1],starShip.getPosition()[2]);
		beam.add(newBeam);
		System.out.println("fired");
	}
	
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		this.width = width;
		this.height = height;
		gl.glViewport(0, 0, width, height);
		
	}

	public void onSurfaceCreated(GL10 gl, EGLConfig arg1) {

        gl.glMatrixMode(GL10.GL_PROJECTION);
        float size = .01f * (float) Math.tan(Math.toRadians(45.0) / 2); 
        float ratio = width / height;
        gl.glFrustumf(-size, size, -size / ratio, size / ratio, 0.007f, 100.0f);
        gl.glViewport(0, 0, (int) width, (int) height);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glEnable(GL10.GL_DEPTH_TEST);
	    gl.glClearColor(0f, 0f, 0f, 1.0f);
	    gl.glEnable(GL10.GL_CULL_FACE);
	    gl.glFrontFace(GL10.GL_CCW);
	    gl.glCullFace(GL10.GL_BACK);	    
	    gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
	    starShip.initSpaceShipModel();
	    starShip.setRotationVector(0f, 0f, 1f);
		starShip.setPosition(0f, -1f, -2f);

	}

	public void rotateShip(float angle) {
		
		starShip.setRotationAngle(angle);
		
	}
	
}
