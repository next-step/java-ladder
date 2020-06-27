package study3.domain;

import static java.lang.Boolean.FALSE;

public class Direction {
	
	private final boolean left;
    private final boolean right;
    
    public Direction(boolean left, boolean right) {
    	if (left && right) {
            throw new IllegalStateException();
        }
    	
    	this.left = left;
    	this.right = right;
    }
    
    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next() {
        if (this.right) {
            return next(FALSE);
        }
        return next(randomPoint());
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(FALSE, right);
    }
		
    public Direction last() {
        return of(this.right, FALSE);
    }
    
    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
