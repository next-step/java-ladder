package nextstep.ladder.view;

import java.util.List;
import java.util.stream.Collectors;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;

public class ResultView {

  private static final String CONNECT = "-----";
  private static final String DISCONNECT = "     ";
  private static final String BAR = "|";

  private static final String LADDER_PADDING = "   ";
  private static final String PLAYER_PADDING = " ";
  private static final String PLAYER_SEPARATION = " ";
  private final OutputConsumer outputConsumer;

  public ResultView(OutputConsumer outputConsumer) {
    this.outputConsumer = outputConsumer;
  }

  public void writeLadder(final Ladder ladder) {
    outputConsumer.write(formatPlayer(ladder.players()));
    ladder.lines().forEach(line -> outputConsumer.write(this.formatLine(line)));
  }

  private String formatPlayer(final List<Player> players) {
    return players.stream()
                  .map(player -> center(player.name(), 5, ' '))
                  .collect(Collectors.joining(PLAYER_SEPARATION, PLAYER_PADDING, PLAYER_PADDING));
  }

  private String formatLine(final Line line) {
    return line.connects()
               .stream()
               .map(this::formatConnect)
               .collect(Collectors.joining(BAR, LADDER_PADDING + BAR, BAR + LADDER_PADDING));
  }

  private String formatConnect(final boolean connect) {
    if(connect) {
      return CONNECT;
    }
    return DISCONNECT;
  }

  public static String center(final String name, final int size, final char padding) {
    final int emptySize = size - name.length();
    if (emptySize <= 0) {
      return name;
    }
    final int rightPadding = emptySize / 2;
    final int leftPadding = emptySize - rightPadding;
    return String.valueOf(padding).repeat(leftPadding)
            + name
            + String.valueOf(padding).repeat(rightPadding);
  }
}
