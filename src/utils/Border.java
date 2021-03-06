package utils;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Border {
	
	public Vector topLeft;
	public Vector topRight;
	public Vector downLeft;
	public Vector downRight;
	
	public Border(Vector topLeft, Vector topRight, Vector downLeft, Vector downRight) {
		this.topLeft = topLeft;
		this.topRight = topRight;
		this.downLeft = downLeft;
		this.downRight = downRight;
	}
	
	public void render (GraphicsContext gc) {
		gc.setStroke(Color.RED);
		gc.setLineWidth(15);
		gc.strokeRect(topLeft.x, topLeft.y, topRight.x - topLeft.x, downLeft.y - topLeft.y);
	}


}
