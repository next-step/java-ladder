package nextstep.ladder.application.view;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import nextstep.ladder.application.prize.Prize;
import nextstep.ladder.application.prize.Prizes;
import nextstep.ladder.domain.height.Height;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);
	private static final String NAME_DELIMITER = ",";

	private InputView() {
	}

	public static Players getPlayers() {
		System.out.println("참여할 플레이어 이름을 입력하세요. 선수 간에는 콤마(,)로 구분합니다.");
		String nameString = scanner.nextLine();

		AtomicInteger index = new AtomicInteger(0);

		return Arrays.stream(nameString.split(NAME_DELIMITER))
			.map(name -> Player.ofNameAndPosition(name, index.get()))
			.peek(player -> index.getAndIncrement())
			.collect(collectingAndThen(toList(), Players::ofPlayers));
	}

	public static Height getHeights() {
		System.out.println("최대 사다리 높이는 몇 개인가요?");
		String heightString = scanner.nextLine();
		return Height.ofHeight(heightString);
	}

	public static Prizes askPrizes() {
		System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
		String prizeString = scanner.nextLine();

		List<Prize> prizes = Arrays.stream(prizeString.split(NAME_DELIMITER))
			.map(name -> Prize.ofName(name.trim()))
			.collect(Collectors.toList());
		return Prizes.ofPrizes(prizes);
	}

	public static String askPlayerName() {
		System.out.println("결과를 보고 싶은 사람은?");
		return scanner.nextLine();
	}
}
