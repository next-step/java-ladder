package nextstep.ladder.view;

import java.util.Arrays;
import java.util.Scanner;

import nextstep.ladder.domain.ExecutionResult;
import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.exception.UtilCreationException;

public final class InputView {
	public static final String ALL = "all";
	public static final String EXIT = "exit";

	private static final Scanner SCANNER = new Scanner(System.in);

	private static final String SCAN_PARTICIPANTS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
	private static final String PARTICIPANTS_DELIMITER = ",";

	private static final String SCAN_EXECUTION_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
	private static final String EXECUTION_RESULT_DELIMITER = ",";

	private static final String SCAN_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

	private static final String NAME_FOR_PRINT_RESULT = "결과를 보고 싶은 사람은? (모두 : all, 종료 : exit)";

	private InputView() {
		throw new UtilCreationException();
	}

	public static Participants scanParticipants() {
		System.out.println(SCAN_PARTICIPANTS);
		String[] names = SCANNER.nextLine().split(PARTICIPANTS_DELIMITER);
		System.out.println();
		return Participants.createWithNames(Arrays.asList(names));
	}

	public static ExecutionResult scanExecutionResult() {
		System.out.println(SCAN_EXECUTION_RESULT);
		String[] results = SCANNER.nextLine().split(EXECUTION_RESULT_DELIMITER);
		System.out.println();
		return ExecutionResult.create(Arrays.asList(results));
	}

	public static Height scanHeightOfLadder() {
		System.out.println(SCAN_HEIGHT);
		String height = SCANNER.nextLine();
		System.out.println();
		return Height.create(height);
	}

	public static String scanNameForPrintResult() {
		System.out.println(NAME_FOR_PRINT_RESULT);
		String name = SCANNER.nextLine();
		System.out.println();
		return name;
	}
}
