package nextstep.ladder.views;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView extends View {

	private final Scanner scanner;

	public InputView() {
		this.scanner = new Scanner(System.in);
	}

	public String getUserName() {
		out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		return scanner.nextLine();
	}

	public int getLadderHeight() {
		out.println("최대 사다리 높이는 몇 개인가요?");
		return scanner.nextInt();
	}
}
