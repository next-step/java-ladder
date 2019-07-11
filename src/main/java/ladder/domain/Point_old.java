package ladder.domain;

public class Point_old {
	private static final int FIRST_POINT = 0;
	private static final int LINE_DISTANCE= 1;

	private final int index;

	public Point_old(int index) {
		this.index = index;
	}

	public boolean isFirst() {
		return index == FIRST_POINT;
	}

	public boolean isLast(int lastPoint) {
		return index == lastPoint;
	}

	public Point_old move(Direction_old directionOld) {
		return moveLeft(directionOld);
	}

	private Point_old moveLeft(Direction_old directionOld){
		return directionOld.isLeft() ? new Point_old(index - LINE_DISTANCE) : moveRight(directionOld);
	}

	private Point_old moveRight(Direction_old directionOld){
		return directionOld.isRight() ? new Point_old(index + LINE_DISTANCE) : this;
	}


	public int getIndex() {
		return index;
	}

}
