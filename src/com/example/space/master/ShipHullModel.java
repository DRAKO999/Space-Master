package com.example.space.master;

import javax.microedition.khronos.opengles.GL10;

public class ShipHullModel {

	MetalSheetPolygon backTriangle;
	MetalSheetPolygon frontTriangle;
	MetalSheetPolygon leftRectangle;
	MetalSheetPolygon rightRectangle;
	
	public void initShipHullModel() {
		
		backTriangle = new MetalSheetPolygon();
		frontTriangle = new MetalSheetPolygon();
		leftRectangle = new MetalSheetPolygon();
		rightRectangle = new MetalSheetPolygon();
		
		backTriangle.initMetalSheetPolygon(1f, 1f, "triangle");
		frontTriangle.initMetalSheetPolygon(1f, 1f, "triangle");
		leftRectangle.initMetalSheetPolygon(1f, 1f, "rectangle");
		rightRectangle.initMetalSheetPolygon(1f, 1f, "rectangle");
		
		frontTriangle.setPosition(0f, 0f, -1f);
		frontTriangle.setSheetRGBA(1f, 0f, 0f, 1f);
		
		leftRectangle.setRotationVector(1f, 0f, 0f);
		leftRectangle.setRotationAngle(90);
		leftRectangle.setSheetRGBA(0, 0, 1f, 1f);
		
		rightRectangle.setRotationVector(1f, 0f, 0f);
		rightRectangle.setRotationAngle(-90);
		rightRectangle.setSheetRGBA(1f, 1f, 0f, 1f);
		
		backTriangle.setSheetRGBA(0f, 1f, 0f, 1f);
	}
	
	public void drawShipHull(GL10 gl) {
		
		
		frontTriangle.drawMetalSheet(gl);
		backTriangle.drawMetalSheet(gl);
		leftRectangle.drawMetalSheet(gl);
		rightRectangle.drawMetalSheet(gl);
		
	}
	
}
