package nextstep.ladder.view;

import java.util.List;
import java.util.stream.Collectors;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;

public class ResultView {

  private static final String CONNECT = "-";
  private static final String DISCONNECT = " ";
  private static final int LADDER_WIDTH = 5;
  private static final String BAR = "|";

  private static final String SPACE = " ";
  private static final int LADDER_PADDING_SIZE = 2;
  private static final int PLAYER_SEPARATION_SIZE = 1;

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
                  .map(player -> center(player.name(), 5))
                  .collect(Collectors.joining(repeat(SPACE, PLAYER_SEPARATION_SIZE)));
  }

  private String formatLine(final Line line) {
    return line.connects()
               .stream()
               .map(this::formatConnect)
               .collect(Collectors.joining(BAR, repeat(SPACE, LADDER_PADDING_SIZE) + BAR, BAR + repeat(SPACE, LADDER_PADDING_SIZE)));
  }

  private String formatConnect(final boolean connect) {
    if(connect) {
      return repeat(CONNECT, LADDER_WIDTH);
    }
    return repeat(DISCONNECT, LADDER_WIDTH);
  }

  private String repeat(final String character, final int count) {
    return character.repeat(count);
  }

  private String center(final String name, final int size) {
    if (name.length() == size) {
      return name;
    }
    return String.format("%4s ", name);
  }
}
