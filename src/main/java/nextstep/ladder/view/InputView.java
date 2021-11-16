package nextstep.ladder.view;

import java.util.Scanner;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Persons;
import nextstep.ladder.exception.UtilCreationException;

public final class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);

	private static final String SCAN_PERSONS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
	private static final String PERSONS_DELIMITER = ",";

	private static final String SCAN_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

	private InputView() {
		throw new UtilCreationException();
	}

	public static Persons scanPersons() {
		System.out.println(SCAN_PERSONS);
		return Persons.create(SCANNER.nextLine().split(PERSONS_DELIMITER));
	}

	public static Height scanHeightOfLadder() {
		System.out.println(SCAN_HEIGHT);
		return Height.create(SCANNER.nextLine());
	}
}
