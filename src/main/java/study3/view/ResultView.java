package study3.view;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import study3.domain.Point;
import study3.domain.Results;
import study3.domain.Rewards;
import study3.domain.Ladder;
import study3.domain.Line;
import study3.domain.Player;
import study3.domain.Players;

public class ResultView {

	private static final String LADDER_EXECUTE_MESSAGE = "사다리 결과";
	private static final String COLUMN = "|-----";
	private static final String ROW = "|     ";
	private static final String NAMES_FORMAT = "%6s";
	private static final String BLANK = "    ";
	private static final String EXECUTE_MESSAGE = "실행 결과";
	private static final String COLON = ":";

	public ResultView() {
		System.out.println(LADDER_EXECUTE_MESSAGE);
	}
	
	public void viewPlayerList(Players players) {

		players.getPlayers().forEach(player -> System.out.print(String.format(NAMES_FORMAT, player.getPlayerName())));
		System.out.println();
	}

	public void viewRowAndColumn(Ladder ladder) {

		/* TODO : 레더 출력
		 * for(int i=0; i<ladder.getLadder().size(); i++) {
			System.out.println(i+"번째 레더" + ladder.getLadder().get(i).getLine());
		}*/

		ladder.getLadder().forEach(line -> {
			System.out.print(BLANK);
			choiceRowOrColum(line);
		});
	}

	private void choiceRowOrColum(Line line) {
		line.getLine().stream().forEach(point -> printBarAndColumn(getPointDirection(point)));
		System.out.println();
	}

	private boolean getPointDirection(Point point) {
		if (point.getDirection().isRight()) {
			return false;
		}
		return true;
	}

	private void printBarAndColumn(Boolean point) {
		if (point) {
			System.out.print(ROW);
		}
		if (!point) {
			System.out.print(COLUMN);
		}
	}

	public void executeResult(String executeString) {

		Arrays.stream(executeString.replace(" ", "")
				.split(",")).forEach(s -> {
			System.out.print(BLANK + s);
		});

		System.out.println();
	}

	public void allRewardPrint(Results results) {
		System.out.println(EXECUTE_MESSAGE);
		results.getResults()
				.forEach((key, value) -> System.out.println(key.getPlayerName() + COLON + value));
	}

	public void SingleRewardPrint(Results results, String resultNames) {
		Player samePlayer = results.getResults().keySet()
				.stream().filter(player -> player.isEqual(resultNames))
				.findFirst().orElseThrow(() -> new IllegalArgumentException());

		// Question!
		// 아래 코드에서 디미터 법칙(?)을 위반 하고 있는것 같은데 ( 디미터 법칙은 모듈은 자신이 조작하는 객체의 속사정을 몰라야 한다는 법칙이다....)
		// 혹시 힌트나 좋은 의견 있으신가요?
		System.out.println(results.getResults().get(samePlayer));
	}
}
