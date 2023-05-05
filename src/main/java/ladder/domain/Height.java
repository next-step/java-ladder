package ladder.domain;

public class Height {

	private final int height;

	public Height(int height) {
		if (height < 1) {
			throw new IllegalArgumentException("사다리 높이는 최소 1 입니다.");
		}
		this.height = height;
	}
}
