package nextstep.ladder.view;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Person;

public class ResultView {

  private static final String RESULT_MESSAGE = "실행결과";
  private static final String BLANK = " ";
  private static final String LINE = "-----|";
  private static final String NOT_LINE = "     |";
  private static final int MAX_LENGTH = 6;

  public static void printResult(Ladder ladder) {
    printResultFormat();
    printPersons(ladder);
    printLadder(ladder);
  }

  private static void printResultFormat() {
    System.out.println(RESULT_MESSAGE);
    System.out.println(BLANK);
  }

  private static void printPersons(Ladder ladder) {
    ladder.getPersons().stream()
        .map(Person::getName)
        .forEach(name -> {
          int blankCount = MAX_LENGTH - name.length();
          printBlank(blankCount);
          System.out.print(name);
        });
    System.out.println(BLANK);
  }

  private static void printBlank(int blankCount) {
    for (int i = 0; i < blankCount; i++) {
      System.out.print(BLANK);
    }
  }

  private static void printLadder(Ladder ladder) {
    ladder.getLines().stream()
        .map(Line::getPoints)
        .forEach(ResultView::printLine);
  }

  private static void printLine(List<Boolean> points) {
    points.forEach(point -> System.out.print(getLineString(point)));
    System.out.println(BLANK);
  }

  private static String getLineString(boolean isLine) {
    if (isLine) {
      return LINE;
    }
    return NOT_LINE;
  }

}
