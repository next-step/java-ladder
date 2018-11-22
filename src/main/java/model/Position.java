package model;

import java.util.List;

public class Position {
	private Positive x;
	private Direction direction;
	
	private Position(Positive x, Direction direction) {
		this.x = x;
		this.direction = direction;
	}
	
	public static Position of(Positive x) {
		return new Position(x, Direction.STRAIGHT);
	}
	
	
	public static Position of(Positive x, Direction direction) {
		return new Position(x, direction);
	}
	
	
	public Positive getX() {
		return x;
	}
	
	/**
	 * 이동
	 *
	 * @return
	 */
	public Positive move() {
		if (hasLeft()) {
			return moveLeft();
		}
		
		if (hasRight()) {
			return moveRight();
		}
		
		return x;
	}
	
	public Positive moveLeft() {
		return Positive.of(x.getNum() - 1);
	}
	
	public Positive moveRight() {
		return Positive.of(x.getNum() + 1);
	}
	
	public boolean hasLeftOrRight() {
		return hasLeft() || hasRight();
	}
	
	private boolean hasLeft() {
		return Direction.LEFT.equals(direction);
	}
	
	public boolean hasRight() {
		return Direction.RIGHT.equals(direction);
	}
	
	public void setDirectionRight() {
		this.direction = Direction.RIGHT;
	}

	public void setDirectionLeft() {
		this.direction = Direction.LEFT;
	}
}



