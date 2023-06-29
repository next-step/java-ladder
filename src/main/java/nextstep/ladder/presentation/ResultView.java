package nextstep.ladder.presentation;

import java.util.Map;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderBarStatus;
import nextstep.ladder.domain.LadderPoint;
import nextstep.ladder.domain.PlayerName;
import nextstep.ladder.domain.PlayerNames;

public class ResultView {

  private static final String LADDER_BAR = "-";
  private static final String LADDER_BOUNDARY = "|";
  private static final String SPACE = " ";
  private static final int BAR_LENGTH = 5;

  public void printResult(PlayerNames playerNames, Ladder ladder) {
    System.out.println("실행 결과");

    StringBuilder stringBuilder = new StringBuilder();
    for (PlayerName playerName : playerNames.getPlayerNames()) {
      stringBuilder.append(playerNamePrintForm(playerName.getName()));
    }
    stringBuilder.append("\n");

    Map<LadderPoint, LadderBarStatus> ladderBarStatuses = ladder.getLadderBarStatuses();

    for (int row = 0; row < ladder.getLadderLength(); row++) {
      stringBuilder.append(SPACE.repeat(BAR_LENGTH))
          .append(LADDER_BOUNDARY);

      for (int column = 0; column < playerNames.size() - 1; column++) {
        LadderPoint ladderPoint = new LadderPoint(row, ladder.getLadderLength(), column,
            playerNames.size());
        LadderBarStatus ladderBarStatus = ladderBarStatuses.get(ladderPoint);
        stringBuilder.append(
                ladderBarStatus.isEmpty() ? SPACE.repeat(BAR_LENGTH) : LADDER_BAR.repeat(BAR_LENGTH))
            .append(LADDER_BOUNDARY);
      }

      stringBuilder.append("\n");
    }

    System.out.println(stringBuilder);
  }

  private String playerNamePrintForm(String name) {
    int spaceCount = BAR_LENGTH - name.length() + 1;

    return SPACE.repeat(spaceCount) + name;
  }
}
