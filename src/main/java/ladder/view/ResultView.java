package ladder.view;

import java.util.Map.Entry;
import java.util.stream.Collectors;
import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.domain.Ladder;
import ladder.domain.Point;
import ladder.domain.Prize;
import ladder.domain.PrizeResult;
import ladder.domain.Prizes;
import ladder.domain.User;
import ladder.domain.Users;

public class ResultView {

  private static final String HYPHEN = "-----";
  private static final String EMPTY = "     ";
  private static final String RESULT = "실행결과";
  private static final String NAMES_FORMAT = "  %s  ";
  private static final String VERTICAL_LINE = "|";

  public void printLadder(LadderGame ladderGame) {
    System.out.println(RESULT);
    System.out.println(printName(ladderGame.getGameInfo().getUsers()));
    String ladder = printLadderDetail(ladderGame.getLines());
    System.out.println(ladder.substring(0, ladder.length() - 1));
    System.out.println(printPrize(ladderGame.getGameInfo().getPrizes()));
  }


  private String printLadderDetail(Ladder ladder) {
    return ladder.getLines()
        .map(line -> printPoints(line) + System.lineSeparator())
        .collect(Collectors.joining());
  }

  private String printPoints(Line line) {
    return line.getPoints()
        .map(point -> printUsedOrNot(point) + VERTICAL_LINE)
        .collect(Collectors.joining());
  }

  private String printUsedOrNot(Point point) {
    if (point.isUsed()) {
      return HYPHEN;
    }
    return EMPTY;
  }


  private String printPrize(Prizes prizes) {
    return prizes.getPrizes()
        .map(prize -> prize.getPrize())
        .map(prize -> String.format(NAMES_FORMAT, prize))
        .collect(Collectors.joining());
  }

  private String printName(Users users) {
    return users.getUsers()
        .map(user -> user.name())
        .map(name -> String.format(NAMES_FORMAT, name))
        .collect(Collectors.joining());
  }

  public void printAllResult(PrizeResult prizeResult) {
    prizeResult.getResult()
        .entrySet()
        .forEach(result -> System.out.println(
            result.getKey().name() + " : " + result.getValue().getPrize()));
  }

  public void printEachResult(PrizeResult prizeResult, String userName) {
    System.out.println(RESULT);
    String result = "";
    for (Entry<User, Prize> prizeMap : prizeResult.getResult().entrySet()) {
      if (prizeMap.getKey().name().equals(userName)) {
        result = prizeMap.getValue().getPrize();
        break;
      }
    }
    System.out.println(result);

  }
}
