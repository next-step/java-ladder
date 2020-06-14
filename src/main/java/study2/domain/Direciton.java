package study2.domain;

public enum Direciton {
	
	LEFT(true, false),
	RIGHT(false, true),
	NONE(false, false);
	
	private boolean left;
	private boolean right;
	
	private Direciton(boolean left, boolean right) {
		this.left = left;
		this.right = right;
	}
	
	public boolean isRight() {
		return right;
	}
	
	public boolean isLeft() {
		return left;
	}
}
