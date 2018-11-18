package laddergame.domain;

import java.util.Collections;
import java.util.List;

public class LadderFinalResult {

	private List<LadderResult> ladderResults;

	public LadderFinalResult(List<LadderResult> ladderResults) {
		this.ladderResults = ladderResults;
	}

	public List<LadderResult> getLadderResults() {
		return Collections.unmodifiableList(ladderResults);
	}
}
