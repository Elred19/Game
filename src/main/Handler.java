package main;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import mob.Mob;
import utils.Border;
import utils.Collision;
import utils.Vector;

public class Handler extends ArrayList<GameObject> {
	
	private Game game;
	
	public Handler (Game game) {
		this.game = game;
	}
	
	public GameObject exist (Vector pos) {
		for (GameObject obj: this) {
			if (Vector.compare(pos, obj.getPosition())) return obj;
		}
		return null;
	}

	public void process(GraphicsContext gc) {
		for (GameObject obj: this) {
        	obj.update();
        	obj.render(gc);
        }
	}
	
	public void addMob (Mob mob) {
		this.add(mob);
	}
	
	public boolean collide (Border border1, Border border2) {
		return Collision.rect(border1, border2);
	}
	
	public boolean canMoveTo (Mob mob) {
		if (mob.name != "PLAYER") return false;
		Border border = mob.calculBorders();
		for (GameObject other: this) {
			if (mob != other) {
				Border otherBorder = other.calculBorders();
				if (collide(border, otherBorder)) {
					return false;
				}
			}
		}
		return true;
	}
	
}
