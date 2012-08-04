package com.example.space.master;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class SpaceShipModel {
	
	private int noOfVertices = 0;
	private ShortBuffer indexBuffer;
	    // a raw buffer to hold the vertices
	private FloatBuffer vertexBuffer;
	    // a raw buffer to hold the colors
	private FloatBuffer colorBuffer;
	private float posX;
	private float posY;
	private float posZ;
	private float vectorX;
	private float vectorY;
	private float vectorZ;
	private float vectorAngle;
	private short[] indices;
	
	public void initSpaceShipModel() {

		posX = posY = posZ = 0f;
		vectorAngle = 0f;
		vectorX = vectorY = vectorZ = 0f;
		
		float[] coords = {
	    
				   -0.2f, -0.2f,    0f, //bot left front
					0.2f, -0.2f,    0f, //bot right front
					  0f,    0f,    0f, //bot top front
				   -0.2f, -0.2f, -0.2f, //bot left back
				    0.2f, -0.2f, -0.2f, //bot right back
				      0f,    0f, -0.2f, //bot top back
				   -0.4f, -0.3f,    0f, //left wing end
				   -0.4f, -0.3f, -0.2f,
				    0.4f, -0.3f,    0f, //right wing end
				    0.4f, -0.3f, -0.2f,  
				   
		};
	    noOfVertices = coords.length;
	 
	    float[] colors = {
	    		
	            1f, 0f, 0f, 1f, // point 0 red
	            0f, 1f, 0f, 1f, // point 1 green
	            0f, 0f, 1f, 1f, // point 2 blue
	            1f, 1f, 1f, 1f, // point 3 white
	            1f, 0f, 0f, 1f, // point 0 red
	            0f, 1f, 0f, 1f, // point 1 green
	            0f, 0f, 1f, 1f, // point 2 blue
	            1f, 1f, 1f, 1f, // point 3 white
	            0f, 0f, 1f, 1f, // point 2 blue
	            1f, 1f, 1f, 1f, // point 3 white
	            0f, 0f, 1f, 1f, // point 2 blue
	            1f, 1f, 1f, 1f, // point 3 white
	    };
	 
	    	indices = new short[] {
	            
	    		0, 1, 2,
	    		2, 1, 4,
	    		2, 4, 5,
	    		5, 4, 3,
	    		3, 0, 5,
	    		5, 0, 2,
	    		0, 3, 4,
	    		0, 4, 1,
	    		7, 6, 0,
	    		7, 0, 3,
	    		4, 1, 8,
	    		4, 8, 9,
	    		7, 0, 6,
	    		7, 3, 0,
	    		4, 8, 1,
	    		4, 9, 8,
	    		
	    };
		 
		// float has 4 bytes, coordinate * 4 bytes
		ByteBuffer vbb = ByteBuffer.allocateDirect(coords.length * 4);
		vbb.order(ByteOrder.nativeOrder());
		vertexBuffer = vbb.asFloatBuffer();
				    // short has 2 bytes, indices * 2 bytes
		ByteBuffer ibb = ByteBuffer.allocateDirect(indices.length * 2);
		ibb.order(ByteOrder.nativeOrder());
		indexBuffer = ibb.asShortBuffer();
		 
		    // float has 4 bytes, colors (RGBA) * 4 bytes
		ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length * 4);
		cbb.order(ByteOrder.nativeOrder());
		colorBuffer = cbb.asFloatBuffer();
		 
		vertexBuffer.put(coords);
		indexBuffer.put(indices);
		colorBuffer.put(colors);
		 
		vertexBuffer.position(0);
		indexBuffer.position(0);
		colorBuffer.position(0);
		
	}
	
	public void setPosition(float x, float y, float z) {
		
		posY += y;
		posZ += z;
		
		if(x>0) {
			
			if(posX < 1.2f)
				posX +=x;
			
		} else {
			
			if(posX > -1.2f)
				posX +=x;
			
		}
		
	}
	
	public void setRotationVector(float x, float y, float z) {
	
		vectorX = x;
		vectorY = y;
		vectorZ = z;
	
	}
	
	public void setRotationAngle(float angle) {
		
		if(angle > 0) {
			
			if(vectorAngle < 30 )
				vectorAngle += angle;
			
		} else
		{
			if(vectorAngle > -30 )
				vectorAngle += angle;
		}
		
	}
	
	public void drawSpaceShipModel(GL10 gl) {

	    // define the color we want to be displayed as the "clipping wall"
		gl.glEnableClientState(gl.GL_COLOR_ARRAY);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
	    gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);
	    gl.glLoadIdentity();
	    gl.glTranslatef(posX, posY, posZ);
	    gl.glRotatef(15, 1f, 0f, 0f);
	    gl.glRotatef(vectorAngle, vectorX, vectorY, vectorZ);
	    gl.glDrawElements(GL10.GL_TRIANGLES, indices.length , GL10.GL_UNSIGNED_SHORT, indexBuffer);
	    gl.glDisableClientState(gl.GL_COLOR_ARRAY);
	}
	
	public float [] getPosition() {
		
		float [] pos = { posX, posY, posZ };
		
		return pos;
		
	}
	
}
