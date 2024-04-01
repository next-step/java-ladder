package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.LadderHeight;
import ladder.domain.LadderLine;

import java.util.List;
import java.util.Map;

public class ResultView {

  public static final String HEIGHT_MARK = "|";
  public static final String LINE_MARK = "-";
  public static final String EMPTY_MARK = " ";
  public static final Integer LINE_SIZE = 5;
  public static final String PRINT_LINE = LINE_MARK.repeat(LINE_SIZE);
  public static final String EMPTY_LINE = EMPTY_MARK.repeat(LINE_SIZE);

  public void printResult(LadderGame ladderGame) {
    System.out.println("\n실행 결과\n");
    printNames(ladderGame.getUserNames());
    printLadders(ladderGame.getLineInfoMap());
  }

  private static void printNames(List<String> names) {
    names.forEach(name -> System.out.print(name + " "));
    System.out.println();
  }

  private void printLadders(Map<LadderHeight, LadderLine> map) {
    map.values().forEach(lines -> {
      System.out.print(HEIGHT_MARK);
      printLines(lines);
      System.out.println();
    });
  }

  private void printLines(LadderLine lines) {
    for (int index = 0; index < lines.size(); index++) {
      System.out.print(printLine(lines.isTrue(index)));
      System.out.print(HEIGHT_MARK);
    }
  }

  public String printLine(boolean isTrue) {
    if (isTrue) {
      return PRINT_LINE;
    }
    return EMPTY_LINE;
  }
}