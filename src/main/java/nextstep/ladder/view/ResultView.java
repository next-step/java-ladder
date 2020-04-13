package nextstep.ladder.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.PrizeSheet;
import nextstep.ladder.domain.ResultSheet;
import nextstep.ladder.domain.model.Position;
import nextstep.ladder.domain.model.Prize;

public class ResultView {

  private static final String LADDER_RESULT = "사다리 결과";
  private static final String PLAYER_AND_PRIZE_FORMAT = "%6s";
  private static final String LADDER_WITH_LEG = "-----|";
  private static final String LADDER_WITHOUT_LEG = "     |";
  private static final String PLAYER_RESULT_QUESTION = "결과를 보고 싶은 사람은?";
  private static final String EXECUTION_RESULT = "실행 결과";
  private static final String ALL = "all";
  private static final String NONE = "none";
  private static final String RESULT_FORMAT = "%s : %s";

  private Scanner scanner;

  public ResultView() {
    scanner = new Scanner(System.in);
  }

  public void printLadderResult(LadderGame ladderGame, Players players) {
    printWithNewLine(LADDER_RESULT);
    printNames(players);
    printLadder(ladderGame.getLadder());
  }

  private void printNames(Players players) {
    players.getPlayers()
        .forEach(player -> System.out.printf(PLAYER_AND_PRIZE_FORMAT, player.getName()));
  }

  private void printLadder(Ladder ladder) {
    ladder.getLadderLines()
        .forEach(this::printLadderLine);
  }

  private void printLadderLine(LadderLine ladderLine) {
    int width = ladderLine.getWidth();

    System.out.println();
    IntStream.range(0, width)
        .mapToObj(Position::at)
        .forEach(position -> {
           Position moved = ladderLine.move(position);
           String ladderPiece = !position.isFirst() && position.left() == moved ?
               LADDER_WITH_LEG : LADDER_WITHOUT_LEG;

           System.out.print(ladderPiece);
        });
  }

  public void printPrizes(List<String> prizes) {
    System.out.println();
    prizes.forEach(prize -> System.out.printf(PLAYER_AND_PRIZE_FORMAT, prize));
  }

  public void printWinningResult(ResultSheet resultSheet) {
    String playerName = getPlayerName();

    while (!playerName.equals(NONE)) {
      printResult(resultSheet, playerName);

      playerName = getPlayerName();
    }
  }

  private void printResult(ResultSheet resultSheet, String playerName) {
    printWithNewLine(EXECUTION_RESULT);
    if (playerName.equals(ALL)) {
      resultSheet.getResultSheet()
          .forEach((name, prize) -> System.out.println(
              String.format(RESULT_FORMAT, name, prize.getPrize())
          ));
      return;
    }

    System.out.println(resultSheet.checkResult(playerName).getPrize());
  }

  private String getPlayerName() {
    printWithNewLine(PLAYER_RESULT_QUESTION);
    return scanner.nextLine();
  }

  private void printWithNewLine(String sentence) {
    System.out.println();
    System.out.println(sentence);
  }
}
