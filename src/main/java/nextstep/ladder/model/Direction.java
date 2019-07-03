package nextstep.ladder.model;

import static java.lang.Boolean.FALSE;
import static nextstep.ladder.model.LadderPointGenerator.generatePoint;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException("양쪽이 true인 Direction은 생성 불가합니다.");
        }
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(FALSE, right);
    }

    public Direction next() {
        if (this.right) {
            return next(FALSE);
        }
        return next(generatePoint());
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction last() {
        return of(this.right, FALSE);
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (left ? 1231 : 1237);
		result = prime * result + (right ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direction other = (Direction) obj;
		if (left != other.left)
			return false;
		if (right != other.right)
			return false;
		return true;
	}
}