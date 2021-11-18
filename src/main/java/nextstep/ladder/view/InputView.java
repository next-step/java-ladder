package nextstep.ladder.view;

import java.util.Arrays;
import java.util.Scanner;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.exception.UtilCreationException;

public final class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);

	private static final String SCAN_PARTICIPANTS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
	private static final String PARTICIPANTS_DELIMITER = ",";

	private static final String SCAN_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

	private InputView() {
		throw new UtilCreationException();
	}

	public static Participants scanParticipants() {
		System.out.println(SCAN_PARTICIPANTS);
		String[] names = SCANNER.nextLine().split(PARTICIPANTS_DELIMITER);
		return Participants.createWithNames(Arrays.asList(names));
	}

	public static Height scanHeightOfLadder() {
		System.out.println(SCAN_HEIGHT);
		return Height.create(SCANNER.nextLine());
	}
}
