package nextstep.ladder.domain;

public class Ladder {
	private final Rows rows;
	private final GameResults gameResults;

	public Ladder(Rows rows) {
		this.rows = rows;
		this.gameResults = new GameResults();
	}

	public Ladder(Width width, Height height) {
		this.rows = new Rows(width, height);
		this.gameResults = new GameResults();
	}

	public Rows rows() {
		return rows;
	}

	public GameResults gameResults() {
		return gameResults;
	}

	public GameResults playGame(Width width) {
		for (int idx = 0; idx < width.value(); idx++) {
			gameResults.put(idx, rows.calcResultIndex(idx));
		}
		return gameResults;
	}
}
