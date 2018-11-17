package domain;

/**
 * Created by hspark on 16/11/2018.
 */
public class LadderLine {
	private int leftPosition;
	private int rightPosition;
	private boolean drawn;

	public LadderLine(int leftPosition, int rightPosition) {
		this.leftPosition = leftPosition;
		this.rightPosition = rightPosition;
	}

	public void draw(LadderLine previousLadderLine, LadderLineSupplier supplier) {
		this.drawn = supplier.get() && !previousLadderLine.isDrawn();
	}

	public boolean isDrawn() {
		return drawn;
	}

	public boolean isPassable(int position) {
		return (position == leftPosition || position == rightPosition) && isDrawn();
	}

	public int getMovePosition(int position) {
		if (!isPassable(position)) {
			throw new IllegalArgumentException();
		}

		if (this.leftPosition == position) {
			return rightPosition;
		}
		return leftPosition;
	}
}
