package nextstep.ladder.domain;

public class Width {
	private static final int MIN_WIDTH = 2;
	private final int width;

	public Width(int width) {
		this.width = width;
		isOverMin();
	}

	private void isOverMin() {
		if (width < MIN_WIDTH) {
			throw new IllegalArgumentException("사다리 게임 참여인원은 " + MIN_WIDTH + "명보다 커야합니다.");
		}
	}

	public int value() {
		return width;
	}
}
