package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Person;

public class ResultView {

  private static final String RESULT_MESSAGE = "실행결과";
  private static final String BLANK = " ";
  private static final String LINE = "-----|";
  private static final String NOT_LINE = "     |";
  private static final int MAX_LENGTH = 6;
  private static final String COLON = " : ";

  public static void printLadderGame(Ladder ladder, String[] results) {
    printResultFormat();
    printPersons(ladder);
    printLadder(ladder);
    printResult(results);
  }

  private static void printResultFormat() {
    System.out.println(RESULT_MESSAGE);
    System.out.println(BLANK);
  }

  private static void printPersons(Ladder ladder) {
    ladder.getPersons().stream()
        .map(Person::getName)
        .forEach(name -> {
          int blankCount = getBlankCount(name);
          printBlank(blankCount);
          System.out.print(name);
        });
    System.out.println(BLANK);
  }

  private static int getBlankCount(String name) {
    int blankCount = MAX_LENGTH - name.length();
    return blankCount;
  }

  private static void printBlank(int blankCount) {
    IntStream.range(0, blankCount).forEach(i -> System.out.print(BLANK));
  }

  private static void printLadder(Ladder ladder) {
    ladder.getLines().stream()
        .map(Line::getPoints)
        .forEach(ResultView::printLine);
  }

  private static void printResult(String[] results) {
    Arrays.stream(results).forEach(result -> {
      int blankCount = getBlankCount(result);
      printBlank(blankCount);
      System.out.print(result);
    });
    System.out.println(BLANK);
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

  public static void printResult(Ladder ladder, String[] results, String resultName) {
    int resultIndex = ladder.result(resultName);
    System.out.println(results[resultIndex]);
  }

  public static void printResult(Ladder ladder, String[] results) {
    ladder.getPersons().forEach(person -> {
      String name = person.getName();
      System.out.print(name + COLON);
      printResult(ladder, results, name);
    });
  }
}
