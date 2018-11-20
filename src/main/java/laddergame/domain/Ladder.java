package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import laddergame.domain.result.DisplayLadder;
import laddergame.domain.result.LadderErrorResult;
import laddergame.domain.result.LadderFinalResult;
import laddergame.domain.result.LadderResult;
import laddergame.domain.result.Printable;
import laddergame2.domain.LadderLines;

public class Ladder {

	private LadderGameInfo ladderGameInfo;
	private LadderLines ladderLines;

	public Ladder(LadderGameInfo ladderGameInfo, LadderLines ladderLines) {
		this.ladderGameInfo = ladderGameInfo;
		this.ladderLines = ladderLines;
	}

	public DisplayLadder display() {
		return new DisplayLadder(ladderGameInfo, ladderLines);
	}

	public Printable start(String playerName) {
		int playerIndex;
		try {
			playerIndex = ladderGameInfo.getPlayerIndex(playerName);
		} catch (IllegalArgumentException e) {
			return new LadderErrorResult(e.getMessage());
		}
		return getLadderResult(playerIndex);
	}

	public Printable end() {
		int startIndex = 0;
		List<LadderResult> ladderResults = IntStream
				.range(startIndex, ladderGameInfo.getPlayerCount())
				.mapToObj(this::getLadderResult)
				.collect(Collectors.toList());
		return new LadderFinalResult(ladderResults);
	}

	private LadderResult getLadderResult(int playerIndex) {
		int resultIndex = ladderLines.start(playerIndex);
		return new LadderResult(ladderGameInfo.getPlayer(playerIndex),
				ladderGameInfo.getResult(resultIndex));
	}
}
