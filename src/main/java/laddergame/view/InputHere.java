package laddergame.view;

import laddergame.domain.Coordinate;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.participant.Participant;
import laddergame.domain.participant.Participants;
import laddergame.domain.result.Prizes;
import laddergame.dto.GameCriteria;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static laddergame.util.StringUtil.splitByDelimiter;

public class InputHere {

	private static final int START_INDEX = 0;
	private static final String INPUT_SHOULD_INTEGER = "자연수로 입력 해 주세요.";
	private static final String PLEASE_INPUT_PARTICIPANTS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
	private static final String PLEASE_INPUT_PRIZES = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
	private static final String PLEASE_INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
	private static final String PLEASE_INPUT_NAME_WANT_SHOW_RESULT = "결과를 보고 싶은 사람은?";
	private static final Scanner SCANNER = new Scanner(System.in);

	private InputHere() {}

	public static GameCriteria getGameCriteria() {
		Participants participants = getParticipants();
		Prizes prizes = getPrizes(participants.getParticipantsCount());
		LadderHeight ladderHeight = getLadderHeight();
		return new GameCriteria(participants, prizes, ladderHeight);
	}

	public static String getNameWantShowResult() {
		System.out.println(PLEASE_INPUT_NAME_WANT_SHOW_RESULT);
		return getStringValue();
	}

	private static Participants getParticipants() {
		System.out.println(PLEASE_INPUT_PARTICIPANTS_NAME);
		String[] names = getStringArray();
		List<Participant> participants = IntStream.range(START_INDEX, names.length)
											.mapToObj(index -> new Participant(names[index], new Coordinate(index)))
											.collect(Collectors.toUnmodifiableList());
		return new Participants(participants);
	}

	private static Prizes getPrizes(int participantsCount) {
		System.out.println(PLEASE_INPUT_PRIZES);
		String[] names = getStringArray();
		return new Prizes(names, participantsCount);
	}

	private static LadderHeight getLadderHeight() {
		System.out.println(PLEASE_INPUT_LADDER_HEIGHT);
		return new LadderHeight(getIntValue());
	}

	private static String[] getStringArray() {
		String input = getStringValue();
		return splitByDelimiter(input);
	}

	private static int getIntValue() {
		try {
			return SCANNER.nextInt();
		} catch (InputMismatchException e) {
			throw new IllegalArgumentException(INPUT_SHOULD_INTEGER, e);
		} finally {
			SCANNER.nextLine();
		}
	}

	private static String getStringValue() {
		return SCANNER.nextLine();
	}
}
