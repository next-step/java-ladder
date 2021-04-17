package ladder.view;

import ladder.model.line.Ladder;
import ladder.model.line.Line;
import ladder.model.member.Players;

public class ResultView {
  private static final String RESULT_MESSAGE = "실행결과";
  private static final String VERTICAL_LINE = "|";
  private static final int MAX_NAME_SIZE = 5;

  public void showResult(Players players, Ladder ladder) {
    System.out.println(RESULT_MESSAGE);
    players.specificPlayers()
      .stream()
      .map(name -> String.format("%6s", name.name()))
      .forEach(System.out::print);
    System.out.println();

    for(Line line : ladder.lines().specificLines()){
      System.out.print(LadderViewLineType.HORIZONTAL_NORMAL_LINE.view());
      showSpecificPoints(line);
      System.out.println();
    }
  }

  private void showSpecificPoints(Line line){
    line.points()
      .specificPoints()
      .forEach(point -> System.out.print(VERTICAL_LINE + LadderViewLineType.findByPoint(point).view()));
  }
}
