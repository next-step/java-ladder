package nextstep.ladder.ui;

import java.util.List;
import java.util.stream.Collectors;

import nextstep.ladder.Player;
import nextstep.ladder.Players;
import nextstep.ladder.Prize;
import nextstep.ladder.biz.Ladder;
import nextstep.ladder.biz.Line;
import nextstep.ladder.biz.Point;

public class LadderRenderer implements Renderer {

  private static final String AIR = "        ";
  private static final String BRIDGE = "--------";
  private static final String PIER = "|";

  private Players players;
  private Ladder ladder;
  private List<Prize> prizes;

  public LadderRenderer(Players players, Ladder ladder, List<Prize> prizes) {
    this.players = players;
    this.ladder = ladder;
    this.prizes = prizes;
  }

  @Override
  public void render() {
    renderPlayers(players);
    renderLadder(ladder);
    renderPrizes(prizes);
  }

  public void renderLadder(Ladder ladder) {
    for (Line line : ladder.getLines()) {
      renderLadder(line);
    }
  }

  private void renderLadder(Line line) {
    System.out.printf("%4s%s\n", "", pointToBridge(line.getPoints()));
  }

  private String pointToBridge(List<Point> points) {
    return points.stream()
            .map(this::toBridge)
            .collect(Collectors.joining(PIER, PIER, PIER));
  }

  private String toBridge(Point point) {
    return point.hasPoint() ? BRIDGE : AIR;
  }

  private void renderPlayers(Players playerNames) {
    System.out.println(playerNames.nameAsList().stream()
            .map(LadderRenderer::center)
            .collect(Collectors.joining("", "\n", "")));
  }

  private void renderPrizes(List<Prize> prizes) {
    System.out.println(
            prizes.stream()
                    .map(Prize::getName)
                    .map(LadderRenderer::center)
                    .collect(Collectors.joining()));

  }

  static String center(String text) {
    int emptyCount = BRIDGE.length() + PIER.length() - text.length();
    int lpad = emptyCount / 2;
    int rpad = emptyCount - lpad;

    return String.format("%s%s%s", padding(lpad), text, padding(rpad));
  }

  static String padding(int length) {
    return String.format("%" + length + "s", "");
  }

}
