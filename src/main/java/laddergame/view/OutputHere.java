package laddergame.view;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.participant.Participant;
import laddergame.domain.participant.Participants;
import laddergame.domain.point.Point;

import java.util.stream.Collectors;

public class OutputHere {

	private static final String CONSTRUCTION_RESULT_MESSAGE = "실행결과";
	private static final String FIVE_LENGTH_SPACE = "     ";
	private static final String FIVE_LENGTH_HYPHEN = "-----";
	private static final String POINT_INDICATOR = "|";
	private static final int NAME_START_INDEX = 0;

	private OutputHere() {}

	public static void printConstructedGame(Participants participants, Ladder ladder) {
		System.out.println(CONSTRUCTION_RESULT_MESSAGE);
		printParticipantsNames(participants);
		printLadder(ladder);

	}

	private static void printParticipantsNames(Participants participants) {
		String participantsNames = participants.getParticipants()
										.values()
										.stream()
										.map(Participant::getName)
										.map(OutputHere::padToSameLength)
										.collect(Collectors.joining(" "));
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
