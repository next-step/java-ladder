package laddergame.view;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.participant.Participant;
import laddergame.domain.point.Point;
import laddergame.dto.GameCriteria;
import laddergame.dto.GameResult;
import laddergame.domain.LadderGame;

import java.util.stream.Collectors;

public class OutputHere {

	public static final String RESULT_ALL_KEYWORD = "all";
	private static final String PLAY_RESULT_MESSAGE = "실행 결과";
	private static final String RESULT_ALL_FORMAT = "%s : %s";
	private static final String PREPARED_RESULT_MESSAGE = "사다리 결과";
	private static final String FIVE_LENGTH_SPACE = "     ";
	private static final String FIVE_LENGTH_HYPHEN = "-----";
	private static final String POINT_INDICATOR = "|";
	private static final String HORIZON_ELEMENT_DELIMITER = " ";
	private static final int NAME_START_INDEX = 0;

	private OutputHere() {}

	public static void printPreparedGame(LadderGame ladderGame) {
		System.out.println(PREPARED_RESULT_MESSAGE);
		printParticipantsNames(ladderGame.getGameCriteria());
		printLadder(ladderGame.getLadder());
		printPreparedResult(ladderGame.getGameCriteria());
	}

	public static void printLadderGameResult(String name, GameResult gameResult) {
		System.out.println(PLAY_RESULT_MESSAGE);
		if(RESULT_ALL_KEYWORD.equals(name)) {
			printAllResult(gameResult);
			return;
		}
		printResultByName(name, gameResult);
	}

	private static void printResultByName(String name, GameResult gameResult) {
		System.out.println(gameResult.getResultOfSpecificOne(name));
	}

	private static void printAllResult(GameResult gameResult) {
		String allResult = gameResult.getAllGameResult()
							.stream()
							.map(entry -> String.format(RESULT_ALL_FORMAT, entry.getKey(), entry.getValue()))
							.collect(Collectors.joining(System.lineSeparator()));
		System.out.println(allResult);
	}

	private static void printParticipantsNames(GameCriteria gameCriteria) {
		String participantsNames = gameCriteria.getParticipantsAsCollection()
										.stream()
										.map(Participant::getName)
										.map(OutputHere::padToSameLength)
										.collect(Collectors.joining(HORIZON_ELEMENT_DELIMITER));
		System.out.println(participantsNames);
	}

	private static void printLadder(Ladder ladder) {
		String ladderShape = ladder.getLines()
							.stream()
							.map(line -> line.getPoints()
									.stream()
									.map(OutputHere::transformPointToString)
									.collect(Collectors.joining())
							)
							.collect(Collectors.joining(System.lineSeparator()));
		System.out.println(ladderShape);
	}

	private static void printPreparedResult(GameCriteria gameCriteria) {
		String resultsString = gameCriteria.getPrizesAsCollection()
								.stream()
								.map(OutputHere::padToSameLength)
								.collect(Collectors.joining(HORIZON_ELEMENT_DELIMITER));
		System.out.println(resultsString);
	}



	private static String transformPointToString(Point point) {
		return POINT_INDICATOR + getAppendSymbol(point);
	}

	private static String getAppendSymbol(Point point) {
		if (point.isRightDirection()) {
			return FIVE_LENGTH_HYPHEN;
		}
		return FIVE_LENGTH_SPACE;
	}

	private static String padToSameLength(String name) {
		StringBuilder stringBuilder = new StringBuilder(FIVE_LENGTH_SPACE);
		stringBuilder.replace(NAME_START_INDEX, name.length(), name);
		return stringBuilder.toString();
	}
}
