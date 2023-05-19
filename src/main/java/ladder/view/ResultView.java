package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.ladder.line.Line;
import ladder.domain.ladder.line.LinePoint;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderPointDirection;
import ladder.domain.ladder.player.LadderGamePlayerInfo;
import ladder.domain.player.Player;

public class ResultView {

  public void printPlayers(LadderGamePlayerInfo playerInfo) {
    final String playerView = playerInfo.getPlayers().stream()
        .map(Player::getName)
        .map(name -> String.format("%-5s", name))
        .collect(Collectors.joining(" "));

    System.out.println(playerView);
  }

  public void printLadders(Ladder ladder) {
    final String ladderView = ladder.getLines().stream()
        .map(Line::getPoints)
        .map(this::pointsToStr)
        .collect(Collectors.joining("\n"));

    System.out.println(ladderView);
  }

  private String pointsToStr(List<LinePoint> points) {
    return points.stream()
        .map(this::pointToView)
        .collect(Collectors.joining());
  }

  private String pointToView(LinePoint point) {
    if (point.getPointDirection() == LadderPointDirection.RIGHT) {
      return String.format("%-6s", "|-----");
    }

    return String.format("%-6s", "|") ;
  }
}
