package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.Line.Line;
import ladder.domain.Line.LinePoint;
import ladder.domain.ladder.LadderPointDirection;
import ladder.domain.player.Player;

public class ResultView {

  public void printPlayers(List<Player> players) {
    final String playerView = players.stream()
        .map(Player::getName)
        .map(name -> String.format("%-5s", name))
        .collect(Collectors.joining(" "));

    System.out.println(playerView);
  }

  public void printLadders(List<Line> ladderLines) {
    final String ladderView = ladderLines.stream()
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
