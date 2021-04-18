package ladder.view;

import ladder.model.Ladder;
import ladder.model.line.Line;
import ladder.model.member.Players;
import ladder.model.prize.Prizes;
import ladder.model.result.LadderTotalResult;
import ladder.model.result.LadderTotalResults;

public class ResultView {
  private static final String LADDER_ALERT = "사다리 결과";
  private static final String RESULT_MESSAGE = "실행결과";
  private static final String VERTICAL_LINE = "|";
  private static final String NAMES_FORMAT = "%6s";

  public void showLadder(Players players, Ladder ladder, Prizes prizes) {
    System.out.println(LADDER_ALERT);
    showPlayers(players);

    for (Line line : ladder.lines().specificLines()) {
      System.out.print(LadderViewLineType.HORIZONTAL_NORMAL_LINE.view());
      showSpecificPoints(line);
      System.out.println();
    }
    showPrizes(prizes);
  }

  public void showResult(LadderTotalResults ladderTotalResults) {
    System.out.println(RESULT_MESSAGE);
    StringBuilder stringBuilder = new StringBuilder();
    for (LadderTotalResult ladderTotalResult : ladderTotalResults.results()) {
      stringBuilder
        .append(ladderTotalResult.player().name())
        .append(" : ")
        .append(ladderTotalResult.prize().prize())
        .append(System.lineSeparator());
    }
    System.out.print(stringBuilder.toString());
  }

  public void showResult(LadderTotalResult ladderTotalResult) {
    System.out.println(RESULT_MESSAGE);
    System.out.println(ladderTotalResult.prize().prize());
    System.out.println();
  }

  private void showPlayers(Players players) {
    players.specificPlayers()
      .stream()
      .map(name -> String.format(NAMES_FORMAT, name.name()))
      .forEach(System.out::print);
    System.out.println();
  }

  private void showPrizes(Prizes prizes) {
    prizes.specificPrizes()
      .stream()
      .map(prize -> String.format(NAMES_FORMAT, prize.prize()))
      .forEach(System.out::print);
    System.out.println();
  }

  private void showSpecificPoints(Line line) {
    line.points()
      .specificPoints()
      .forEach(point -> System.out.print(VERTICAL_LINE + LadderViewLineType.findByPoint(point).view()));
  }

}
