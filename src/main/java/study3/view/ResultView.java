package study3.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import study3.domain.Point;
import study3.domain.Ladder;
import study3.domain.Line;
import study3.domain.Players;

public class ResultView {

	private static final String EXECUTE_MESSAGE = "실행결과";
	private static final String COLUMN = "|-----";
	private static final String ROW = "|     ";
	private static final String NAMES_FORMAT = "%6s";
	private static final String BLANK = "    ";
	

	public ResultView(Players players, Ladder ladder) {

		System.out.println(EXECUTE_MESSAGE);
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
	public String[] executeResult(String executeString) {
		
		String[] resultString = executeString
							.replace(" ", "")
							.split(",");
		
		for(int i=0; i<resultString.length; i++) {
			System.out.print(BLANK +resultString[i] );
		}
		System.out.println();
		return resultString;
	}
}	
