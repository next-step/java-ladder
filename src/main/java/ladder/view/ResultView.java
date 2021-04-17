package ladder.view;

import ladder.model.line.Ladder;
import ladder.model.line.Line;
import ladder.model.member.Players;
import ladder.model.prize.Prizes;

public class ResultView {
  private static final String LADDER_ALERT = "사다리 결과";
  private static final String RESULT_MESSAGE = "실행결과";
  private static final String VERTICAL_LINE = "|";

  public void showLadder(Players players, Ladder ladder, Prizes prizes) {
    System.out.println(LADDER_ALERT);
    showPlayers(players);

    for(Line line : ladder.lines().specificLines()){
      System.out.print(LadderViewLineType.HORIZONTAL_NORMAL_LINE.view());
      showSpecificPoints(line);
      System.out.println();
    }
    showPrizes(prizes);
  }

  private void showPlayers(Players players){
    players.specificPlayers()
      .stream()
      .map(name -> String.format("%6s", name.name()))
      .forEach(System.out::print);
    System.out.println();
  }

  private void showPrizes(Prizes prizes){
    prizes.specificPrizes()
      .stream()
      .map(prize -> String.format("%6s", prize.prize()))
      .forEach(System.out::print);
    System.out.println();
  }

  private void showSpecificPoints(Line line){
    line.points()
      .specificPoints()
      .forEach(point -> System.out.print(VERTICAL_LINE + LadderViewLineType.findByPoint(point).view()));
  }
}
