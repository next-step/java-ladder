package nextstep.ladder.domain;

import nextstep.ladder.engine.Ladder;

public class CustomLadder implements Ladder {
	private final Rows rows;
	private final GameResults gameResults;

	public CustomLadder(Rows rows) {
		this.rows = rows;
		this.gameResults = new GameResults();
	}

	public CustomLadder(Width width, Height height) {
		this.rows = new Rows(width, height);
		this.gameResults = new GameResults();
	}

	@Override
	public Rows rows() {
		return rows;
	}

	@Override
	public GameResults play(Width width) {
		int widthValue = width.value();
		for (int idx = 0; idx < widthValue; idx++) {
			gameResults.put(idx, rows.calcResultIndex(idx));
		}
		return gameResults;
	}
}
