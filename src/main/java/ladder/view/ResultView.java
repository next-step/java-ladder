package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.Line.Line;
import ladder.domain.player.Player;

public class ResultView {

  public void printPlayers(List<Player> players) {
    final String playerView = players.stream()
        .map(Player::toString)
        .collect(Collectors.joining(" "));

    System.out.println(playerView);
  }

  public void printLadders(List<Line> ladderLines) {
    String ladderView = ladderLines.stream()
        .map(Line::toString)
        .collect(Collectors.joining("\n"));
    System.out.println(ladderView);
  }
}
