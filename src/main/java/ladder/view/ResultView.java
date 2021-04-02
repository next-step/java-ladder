package ladder.view;

import java.util.stream.Collectors;
import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.domain.Lines;
import ladder.domain.Point;
import ladder.domain.Users;

public class ResultView {

  private static final String HYPHEN = "-----";
  private static final String EMPTY = "     ";
  private static final String RESULT = "실행결과";
  private static final String NAMES_FORMAT = "%s   ";
  private static final String VERTICAL_LINE = "|";

  public void printLadder(LadderGame ladderGame) {
    System.out.println(RESULT);
    System.out.println(printName(ladderGame.getUsers()));
    System.out.println(printLadderDetail(ladderGame.getLines()));
  }

  private String printLadderDetail(Lines lines) {

    return lines.getLines()
        .map(line -> printPoints(line) + System.lineSeparator())
        .collect(Collectors.joining());
  }

  private String printPoints(Line line) {
    return line.getPoints().stream()
        .map(point -> printUsedOrNot(point) + VERTICAL_LINE)
        .collect(Collectors.joining());
  }

  private String printUsedOrNot(Point point) {
    if (point.isUsed()) {
      return HYPHEN;
    }
    return EMPTY;
  }


  private String printName(Users users) {
    return users.getUsers().stream()
        .map(user -> user.getName())
        .map(name -> String.format(NAMES_FORMAT, name))
        .collect(Collectors.joining());
  }
}
