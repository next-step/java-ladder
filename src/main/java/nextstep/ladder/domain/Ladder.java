package nextstep.ladder.domain;

public class Ladder {
	private final Rows rows;

	public Ladder(Rows rows) {
		this.rows = rows;
	}

	public Ladder(Width width, Height height) {
		this.rows = new Rows(width, height);
	}

	public Rows rows() {
		return rows;
	}
}
