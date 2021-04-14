package step2.view;

import step2.model.line.Ladder;
import step2.model.name.Names;

public class ResultView {
  private static final String RESULT_MESSAGE = "실행결과";
  private static final String VERTICAL_LINE = "|";
  private static final int MAX_NAME_SIZE = 5;

  public void showResult(Names names, Ladder ladder) {
    System.out.println(RESULT_MESSAGE);
    names.stream()
      .map(name -> String.format("%6s", name.name()))
      .forEach(System.out::print);
    System.out.println();

    ladder.lines().stream()
      .forEach(line -> {
          System.out.print(LadderResultView.HORIZONTAL_NORMAL_LINE.view());
          line.points().stream()
            .forEach(point -> {
              System.out.print(VERTICAL_LINE + LadderResultView.findByPoint(point).view());
            });
          System.out.println();
        }
      );
  }
}
