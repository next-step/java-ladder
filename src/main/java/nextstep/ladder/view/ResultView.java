package nextstep.ladder.view;

import java.util.List;
import java.util.Map;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.LadderMatcher;
import nextstep.ladder.domain.Persons;
import nextstep.ladder.domain.Results;

public class ResultView {

  public static final String PERSON_AND_RESULT_FORMAT = "%6s";
  public static final String BLANK = " ";
  public static final String LADDER_RESULT_FORMAT = "%s : %s";

  public static void printLadderGame(LadderMatcher ladderMatcher, Ladder ladder) {
    printNames(ladderMatcher.getPersons());
    printLadder(ladder);
    printResult(ladderMatcher.getResults());
  }

  public static void printLadder(Ladder ladder) {
    List<LadderLine> lines = ladder.getLines();
    lines.forEach(System.out::println);
  }

  private static void printNames(Persons persons) {
    persons.getPersons()
        .forEach(person -> System.out.print(String.format(PERSON_AND_RESULT_FORMAT, person.getName())));
    System.out.println(BLANK);
  }

  private static void printResult(Results results) {
    results.getResults()
        .forEach(result -> System.out.print(String.format(PERSON_AND_RESULT_FORMAT, result.getName())));
    System.out.println(BLANK);
  }
  
  public static void printLadderResult(Map<String, String> moveResult, String startName) {
    String result = moveResult.get(startName);
    String message = String.format(LADDER_RESULT_FORMAT, startName, result);
    System.out.println(message);
  }

  public static void printLadderResults(Map<String, String> moveResult) {
    moveResult.forEach((key, value) -> System.out.println(String.format("%s : %s", key, value)));
  }
}
