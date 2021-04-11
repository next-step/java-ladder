package nextstep.ladder.io;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.People;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.Point;
import nextstep.ladder.utils.StringUtils;

public final class ResultView {

  public static final String LINE_SEPARATOR = System.lineSeparator();

  private ResultView() {}

  public static void printLadder(Ladder ladder) {
    System.out.println();
    System.out.println("실행결과");
    System.out.println();
    printPeople(ladder.people());
    printLines(ladder.lines());
  }

  private static void printPeople(People people) {
    List<Person> personList = people.personList();
    StringBuilder peopleBuilder = new StringBuilder();
    for (Person person : personList) {
      peopleBuilder.append(StringUtils.padLeft(person.personName(), Name.MAX_LENGTH + 1));
    }
    System.out.println(peopleBuilder);
  }

  private static void printLines(List<Line> lines) {
    StringBuilder linesBuilder = new StringBuilder();
    for (Line line : lines) {
      for (Point point : line.points()) {
        linesBuilder.append(point.draw());
      }
      linesBuilder.append(LINE_SEPARATOR);
    }
    System.out.println(linesBuilder);
  }
}
