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
		return Integer.parseInt(scanner.nextLine());
	}

	public String getPrizeResult() {
		out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
		return scanner.nextLine();
	}

	public String getParticipant() {
		out.println("결과를 보고 싶은 사람은?");
		return scanner.nextLine();
	}
}
