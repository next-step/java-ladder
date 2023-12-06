package nextstep.ladder.view;

import java.util.List;
import java.util.Scanner;

import nextstep.ladder.domain.User;
import nextstep.ladder.domain.util.StringSplitter;

public class InputView {
	private static Scanner sc = new Scanner(System.in);

	public static List<User> inputUsers() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)");
		return StringSplitter.splitByComma(sc.nextLine());
	}
}
