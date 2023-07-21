package nextstep.ladder.presentation;

import java.util.List;
import java.util.Map;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderBarStatus;
import nextstep.ladder.domain.LadderPoint;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.dto.GameResults;

public class ResultView {

  private static final String LADDER_BAR = "-";
  private static final String LADDER_BOUNDARY = "|";
  private static final String SPACE = " ";
  private static final int BAR_LENGTH = 5;

  public static void printResult(Players players, Ladder ladder, GameResults gameResults) {
    List<Player> playerList = players.getPlayers();
    System.out.println("실행 결과");

    StringBuilder stringBuilder = new StringBuilder();
    for (Player player : playerList) {
      stringBuilder.append(playerNamePrintForm(player.getPlayerName().getName()));
    }
    stringBuilder.append("\n");

    Map<LadderPoint, LadderBarStatus> ladderBarStatuses = ladder.getLadderBarStatuses();

    for (int row = 0; row < ladder.getLadderLength(); row++) {
      stringBuilder.append(SPACE.repeat(BAR_LENGTH))
          .append(LADDER_BOUNDARY);

      for (int column = 0; column < players.size() - 1; column++) {
        LadderPoint ladderPoint = new LadderPoint(row, ladder.getLadderLength(), column,
            players.size());
        LadderBarStatus ladderBarStatus = ladderBarStatuses.get(ladderPoint);
        stringBuilder.append(
                ladderBarStatus.isEmpty() ? SPACE.repeat(BAR_LENGTH) : LADDER_BAR.repeat(BAR_LENGTH))
            .append(LADDER_BOUNDARY);
      }

      stringBuilder.append("\n");
    }

    for (String gameResult : gameResults.getResults()) {
      stringBuilder.append(playerNamePrintForm(gameResult));
    }

    System.out.println(stringBuilder);
  }

  public static void printTargetsResult(Players players) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("실행 결과\n");

    for (Player player : players.getPlayers()) {
      stringBuilder.append(player.getPlayerName().getName())
          .append(" : ")
          .append(player.getResult())
          .append("\n");
    }

    System.out.println(stringBuilder);
  }

  public static void printTargetResult(Player player) {
    System.out.println(player.getResult());
  }


  private static String playerNamePrintForm(String name) {
    int spaceCount = BAR_LENGTH - name.length() + 1;

    return SPACE.repeat(spaceCount) + name;
  }
}
