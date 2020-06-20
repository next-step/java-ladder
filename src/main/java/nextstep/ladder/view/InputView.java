package nextstep.ladder.view;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import nextstep.ladder.height.Height;
import nextstep.ladder.player.Player;
import nextstep.ladder.player.Players;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);
	private static final String PLAYER_NAME_DELIMITER = ",";

	private InputView() {
	}

	public static Players getPlayers() {
		System.out.println("참여할 플레이어 이름을 입력하세요. 선수 간에는 콤마(,)로 구분합니다.");
		String nameString = scanner.nextLine();

		AtomicInteger index = new AtomicInteger(0);

		return Arrays.stream(nameString.split(PLAYER_NAME_DELIMITER))
			.map(name -> Player.ofNameAndPosition(name, index.get()))
			.peek(player -> index.getAndIncrement())
			.collect(collectingAndThen(toList(), Players::ofPlayers));
	}

	public static Height getHeights() {
		System.out.println("최대 사다리 높이는 몇 개인가요?");
		String heightString = scanner.nextLine();
		return Height.ofHeight(heightString);
	}
}
