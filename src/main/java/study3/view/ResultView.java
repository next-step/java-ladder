package study3.view;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import study3.domain.Point;
import study3.domain.Results;
import study3.domain.Reward;
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

	public ResultView(Players players, Ladder ladder) {

		System.out.println(LADDER_EXECUTE_MESSAGE);
		viewPlayerList(players);
		viewRowAndColumn(ladder);
	}

	private void viewPlayerList(Players players) {
		
		players.getPlayers().forEach(
				player -> System.out.print(
						String.format(NAMES_FORMAT, player.getPlayerName())));
		System.out.println();
	}

	private void viewRowAndColumn(Ladder ladder) {
		
		/* TODO : 레더 출력
		 * for(int i=0; i<ladder.getLadder().size(); i++) {
			System.out.println(i+"번째 레더" + ladder.getLadder().get(i).getLine());
		}*/

		ladder.getLadder().forEach(line -> 	{
			System.out.print(BLANK);
			choiceRowOrColum(line);
			});
	}

	private void choiceRowOrColum(Line line) {
		line.getLine().stream()
		.forEach(point -> 
				printBarAndColumn(getPointDirection(point)));
		System.out.println();
	}
	
	private boolean getPointDirection(Point point) {
		if(point.getDirection().isRight()) {
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
	public Rewards executeResult(String executeString) {
		
			Arrays.stream(executeString.replace(" ", "")
				.split(","))
			.forEach(s-> {
				System.out.print(BLANK + s);
			});		
		
		System.out.println();
		return new Rewards (
				Arrays.stream(executeString.replace(" ", "")
				.split(","))
				.collect(Collectors.toList()));
	}

	public void allRewardPrint(Results results) {
		System.out.println(EXECUTE_MESSAGE);
		results.getResults()
			.forEach((key, value) -> System.out.println(key.getPlayerName() + COLON + value.getReward()));
	}

	public void SingleRewardPrint(Results results, String resultNames) {
		Player samePlayer = results.getResults().keySet().stream()
				.filter(player -> player.isEqual(resultNames))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException());
		System.out.println(results.getResults().get(samePlayer).getReward());
	}
}	
