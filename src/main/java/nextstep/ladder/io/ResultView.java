package nextstep.ladder.io;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.People;
import nextstep.ladder.domain.Person;
import nextstep.ladder.utils.StringUtils;

public final class ResultView {

  private ResultView() {}

  public static void printNewLine() {
    System.out.println();
  }

  public static void printLadder(Ladder ladder) {
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
    System.out.println(peopleBuilder.toString());
  }

  private static void printLines(List<Line> lines) {
    System.out.println("     |     |     |     |     |     |");
    System.out.println("     |-----|     |-----|     |-----|");
    System.out.println("     |     |-----|     |     |-----|");
  }
}
