package laddergame.domain;

import laddergame.domain.coordinate.Coordinate;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.participant.Participant;
import laddergame.domain.prize.Prizes;
import laddergame.dto.GameCriteria;
import laddergame.dto.GameResult;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LadderGame {

	private final GameCriteria gameCriteria;
	private final Ladder ladder;

	private LadderGame(GameCriteria gameCriteria, Ladder ladder) {
		this.gameCriteria = gameCriteria;
		this.ladder = ladder;
	}

	public static LadderGame of(GameCriteria gameCriteria, Ladder ladder) {
		return new LadderGame(gameCriteria, ladder);
	}

	public GameCriteria getGameCriteria() {
		return gameCriteria;
	}

	public Ladder getLadder() {
		return ladder;
	}

	public GameResult rumGame() {
		Map<String, String> gameResults = gameCriteria.getParticipantsAsCollection()
													.stream()
													.collect(Collectors.toMap(Participant::getName, getParticipantPrize(), (participant1, participant2) -> participant1, LinkedHashMap::new));
		return new GameResult(gameResults);
	}

	private Function<Participant, String> getParticipantPrize() {
		return participant -> {
			Coordinate resultCoordinate = ladder.getParticipantFinalCoordinate(participant);
			return getPrizeName(gameCriteria.getPrizes(), resultCoordinate);
		};
	}

	private String getPrizeName(Prizes prizes, Coordinate coordinate) {
		return prizes.getResultByResultCoordinate(coordinate);
	}
}
