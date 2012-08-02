package com.example.space.master;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class MetalSheetPolygon {

	private ShortBuffer indexBuffer;
	private FloatBuffer vertexBuffer;
	private float sheetRed;
	private float sheetGreen;
	private float sheetBlue;
	private float sheetAlpha;
	private float positionX;
	private float positionY;
	private float positionZ;
	private float angle;
	private float rotationX;
	private float rotationY;
	private float rotationZ;
	
	public MetalSheetPolygon() {

		sheetRed = 0f;
		sheetBlue = 0f;
		sheetGreen = 0f;
		sheetAlpha = 0f;
		positionX = 0f;
		positionY = 0f;
		
		rotationX = 1f;
		rotationY = 0f;
		rotationZ = 0f;
		
		angle = 0f;
		
	}
	
	
	public void initMetalSheetPolygon(float width, float height, String shape) {
		
		float [] sheetCoords;
		short [] sheetIndices;
		if(shape.equals("rectangle")) {
			
			float [] sheetCords  = {
					
					-width/2f,  height/2f, 0f,
					-width/2f, -height/2f, 0f,
					 width/2f, -height/2f, 0f,
					 width/2f,  height/2f, 0f	
			
			};
			
			short[] indices = {0, 1, 2, 0, 2, 3};
			sheetIndices = indices;
			sheetCoords = sheetCords;
			
		}
		else {
			
			float [] sheetCords  = {
					
					-width/2f, -height/2f, 0f,
					 width/2f, -height/2f, 0f,
					 	   0f,  height/2f, 0f,
					
			};
			
			short[] indices = {0, 1, 2};
			sheetIndices = indices;
			sheetCoords = sheetCords;
		}
		
	    ByteBuffer vbb = ByteBuffer.allocateDirect(sheetCoords.length * 4);
	    vbb.order(ByteOrder.nativeOrder());
	    vertexBuffer = vbb.asFloatBuffer();
	    
	    ByteBuffer ibb = ByteBuffer.allocateDirect(sheetIndices.length * 2);
	    ibb.order(ByteOrder.nativeOrder());
	    indexBuffer = ibb.asShortBuffer();
	 
	    vertexBuffer.put(sheetCoords);
	    indexBuffer.put(sheetIndices);
	 
	    vertexBuffer.position(0);
	    indexBuffer.position(0);
	    
	}
	
	public void setRotationAngle(float angle) {
		
		this.angle += angle;
		
	}
	
	public void setRotationVector(float x, float y, float z) {
		
		this.rotationX = x;
		this.rotationY = y;
		this.rotationZ = z;
		
	}
	
	public void setPosition(float posX, float posY, float posZ) {
		
		this.positionX = posX;
		this.positionY = posY;
		this.positionZ = posZ;
		
	}
	
	public void drawMetalSheet(GL10 gl) {
		
		gl.glLoadIdentity();
		gl.glTranslatef(positionX, positionY, positionZ);
		gl.glRotatef(angle, rotationX, rotationY, rotationZ);
	    gl.glColor4f(sheetRed, sheetGreen, sheetBlue, sheetAlpha);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
	    gl.glDrawElements(GL10.GL_TRIANGLES, 6, GL10.GL_UNSIGNED_SHORT, indexBuffer);
	    	
	}
	
	public void setSheetRGBA(float R, float G, float B, float A) {
		
		sheetRed = R;
		sheetBlue = B;
		sheetGreen = G;
		sheetAlpha = A;
		
	}

}
