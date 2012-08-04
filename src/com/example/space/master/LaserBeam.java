package com.example.space.master;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class LaserBeam {
	
	private ShortBuffer indexBuffer;
	private FloatBuffer vertexBuffer;
	private float posX;
	private float posY;
	private float posZ;
	private float vectorX;
	private float vectorY;
	private float vectorZ;
	private float vectorAngle;
	private short[] indices;
	
	public void initLaserBeam() {

		posX = posY = posZ = 0f;
		vectorAngle = 0f;
		vectorX = vectorY = vectorZ = 0f;
		
		float[] coords = {
	    
				-0.03f, -0.025f,   0f,
				 0.03f, -0.025f,   0f,
				-0.03f, -0.025f, -0.5f,
				 0.03f, -0.025f, -0.5f,
				
		};
	 
    	indices = new short[] {
	    
    			0, 1, 2,
    			2, 1, 3
	    		
	    };
		 
		// float has 4 bytes, coordinate * 4 bytes
		ByteBuffer vbb = ByteBuffer.allocateDirect(coords.length * 4);
		vbb.order(ByteOrder.nativeOrder());
		vertexBuffer = vbb.asFloatBuffer();
				    // short has 2 bytes, indices * 2 bytes
		ByteBuffer ibb = ByteBuffer.allocateDirect(indices.length * 2);
		ibb.order(ByteOrder.nativeOrder());
		indexBuffer = ibb.asShortBuffer();
		 
		vertexBuffer.put(coords);
		indexBuffer.put(indices);
		 
		vertexBuffer.position(0);
		indexBuffer.position(0);
		
	}
	
	public void setPosition(float x, float y, float z) {
		
		posX += x;
		posY += y;
		posZ += z;
		
	}
	
	public void setRotationVector(float x, float y, float z) {
	
		vectorX = x;
		vectorY = y;
		vectorZ = z;
	
	}
	
	
	public void drawLaserBeam(GL10 gl) {

		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
	    gl.glLoadIdentity();
	    gl.glColor4f(1f, 0f, 0f, 0.5f);
	    gl.glTranslatef(posX, posY, posZ);
	    gl.glRotatef(30, 1f, 0f, 0f);
	    gl.glRotatef(vectorAngle, vectorX, vectorY, vectorZ);
	    gl.glDrawElements(GL10.GL_TRIANGLES, indices.length , GL10.GL_UNSIGNED_SHORT, indexBuffer);

	}
	
	public float [] getPosition() {
		
		float [] pos = { posX, posY, posZ };
		
		return pos;
		
	}

}
