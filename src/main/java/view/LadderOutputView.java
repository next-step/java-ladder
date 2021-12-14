package view;

import domain.Floor;
import domain.Ladder;
import domain.Player;
import domain.Players;
import domain.Point;

import java.util.List;

import static common.Constants.*;

public class LadderOutputView {
  
  public static void showNames(Players players) {
    StringBuilder stringBuilder = new StringBuilder();
    List<Player> playerList = players.getPlayers();

    for (int i = 0; i < playerList.size(); i++) {
      stringBuilder.append(checkDivisionNames(i == playerList.size() - 1, playerList.get(i).getName()));
    }

    System.out.println(stringBuilder);
  }

  private static String checkDivisionNames(boolean isLastIndex, String name) {
    StringBuilder stringBuilder = new StringBuilder();

    if (isLastIndex) {
      return stringBuilder.append(name).toString();
    }

    return stringBuilder.append(String.format("%s%s", name, TAB)).toString();
  }

  public static void showLadder(Ladder ladder) {
    StringBuilder stringBuilder = new StringBuilder();
    List<Floor> floors = ladder.getFloors();

    floors.forEach(floor -> {
      stringBuilder.append(VERTICAL_LADDER_LINE);
      stringBuilder.append(makeHorizontalLadderLines(floor.getPoints()));
      stringBuilder.append(NEW_LINE);
    });

    System.out.println(stringBuilder);
  }

  public static String makeHorizontalLadderLines(List<Point> points) {
    StringBuilder stringBuilder = new StringBuilder();

    for (Point point : points) {
      stringBuilder.append(makeHorizontalLadderLineIfHas(point.isHasHorizontalLine()));
      stringBuilder.append("|");
    }

    return stringBuilder.toString();
  }

  private static String makeHorizontalLadderLineIfHas(boolean hasHorizontalLine) {
    return hasHorizontalLine ? HORIZONTAL_LADDER_LINE : HORIZONTAL_LADDER_EMPTY_LINE;
  }

}
