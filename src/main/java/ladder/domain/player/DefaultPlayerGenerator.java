package ladder.domain.player;

import exception.ExceptionCode;
import exception.LadderGameException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.ladder.player.LadderGamePlayerInfo;

public class DefaultPlayerGenerator implements PlayerGenerator {

  private static final int MIN_PLAYER_REQUIRED_CNT = 2;
  private static final DefaultPlayerGenerator INSTANCE;

  static {
    INSTANCE = new DefaultPlayerGenerator();
  }

  private DefaultPlayerGenerator() {}

  public static DefaultPlayerGenerator getInstance() {
    return DefaultPlayerGenerator.INSTANCE;
  }

  @Override
  public LadderGamePlayerInfo generatePlayerList(List<String> playerNames) {
    int playerSize = playerNames.size();

    throwIfLackOfPlayerCount(playerSize);
    throwIfHaveDuplicateUserName(playerNames);

    final List<Player> playerList = IntStream.range(0, playerSize)
        .mapToObj(i -> new Player(playerNames.get(i), i))
        .collect(Collectors.toUnmodifiableList());

    return new LadderGamePlayerInfo(playerList);
  }

  private void throwIfHaveDuplicateUserName(List<String> playerNames) {
    final int distinctPlayerCnt = getDistinctPlayerCount(playerNames);
    if (distinctPlayerCnt != playerNames.size()) {
      throw new LadderGameException(ExceptionCode.DUPLICATE_PLAYER_IN_GAME);
    }
  }

  private void throwIfLackOfPlayerCount(int playerSize) {
    if (MIN_PLAYER_REQUIRED_CNT > playerSize) {
      throw new LadderGameException(ExceptionCode.MIN_PLAYER_COUNT_REQUIRED);
    }
  }

  private int getDistinctPlayerCount(List<String> playerNames) {
    return (int) playerNames.stream()
        .distinct()
        .count();
  }
}
