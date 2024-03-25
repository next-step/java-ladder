package ladder.domain.ladder;

public class Line {
	private final Integer width;
	private final Integer position;

	public Line(Integer width, Integer position) {
		this.width = width;
		this.position = position;
	}

	public static Line createLine(Integer width, Integer position) {
		return new Line(width, position);
	}

	public Integer getWidth() {
		return width;
	}
}
