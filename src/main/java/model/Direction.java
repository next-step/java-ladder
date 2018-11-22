package model;

public enum Direction {
	LEFT(true ,false)
	,RIGHT(false, true)
	, STRAIGHT(false, false);
	
	private boolean left;
	private boolean right;
	
	Direction(boolean left, boolean right) {
		this.left = left;
		this.right = right;
	}
}
