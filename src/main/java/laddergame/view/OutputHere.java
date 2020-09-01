package laddergame.view;

import laddergame.domain.Coordinate;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.participant.Participant;
import laddergame.domain.participant.Participants;
import laddergame.domain.point.Point;
import laddergame.domain.result.Prizes;
import laddergame.dto.GameCriteria;

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

	public static void printPreparedGame(GameCriteria gameCriteria, Ladder ladder) {
		System.out.println(PREPARED_RESULT_MESSAGE);
		printParticipantsNames(gameCriteria.getParticipants());
		printLadder(ladder);
		printPreparedResult(gameCriteria.getPrizes());

	}

	public static void printLadderGameResult(String name, GameCriteria gameCriteria, Ladder ladder) {
		System.out.println(PLAY_RESULT_MESSAGE);
		if(RESULT_ALL_KEYWORD.equals(name)) {
			printAllResult(gameCriteria, ladder);
			return;
		}
		printResultByName(name, gameCriteria, ladder);
	}

	private static void printResultByName(String name, GameCriteria gameCriteria, Ladder ladder) {
		Participant namedParticipant = gameCriteria.getParticipants().getCoordinateByName(name);
		Coordinate resultCoordinate = ladder.playGame(namedParticipant);
		System.out.println(gameCriteria.getPrizes().getResultByResultCoordinate(resultCoordinate));
	}

	private static void printAllResult(GameCriteria gameCriteria, Ladder ladder) {
		String allResult = gameCriteria.getParticipants()
							.getParticipants()
							.stream()
							.map(participant -> {
								Coordinate resultCoordinate = ladder.playGame(participant);
								return String.format(RESULT_ALL_FORMAT, participant.getName(), gameCriteria.getPrizes().getResultByResultCoordinate(resultCoordinate));
							})
							.collect(Collectors.joining(System.lineSeparator()));
		System.out.println(allResult);
	}

	private static void printParticipantsNames(Participants participants) {
		String participantsNames = participants.getParticipants()
										.stream()
										.map(Participant::getName)
										.map(OutputHere::padToSameLength)
										.collect(Collectors.joining(HORIZON_ELEMENT_DELIMITER));
		System.out.println(participantsNames);
	}

	private static void printLadder(Ladder ladder) {
		String ladderShape = ladder.getLines()
							.stream()
							.map(line -> line.getPoints().stream()
									.map(OutputHere::transformPointToString)
									.collect(Collectors.joining())
							)
							.collect(Collectors.joining(System.lineSeparator()));
		System.out.println(ladderShape);
	}

	private static void printPreparedResult(Prizes prizes) {
		String resultsString = prizes.getPrizeNames()
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
