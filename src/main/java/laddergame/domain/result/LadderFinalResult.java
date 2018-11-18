package laddergame.domain.result;

import static laddergame.domain.result.DisplayLadder.NEW_LINE;

import java.util.List;
import java.util.stream.Collectors;

public class LadderFinalResult implements Printable {

	private List<LadderResult> ladderResults;

	public LadderFinalResult(List<LadderResult> ladderResults) {
		this.ladderResults = ladderResults;
	}

	@Override
	public String print() {
		return ladderResults.stream()
				.map(LadderResult::getFormattedResult)
				.collect(Collectors.joining(NEW_LINE));
	}
}
