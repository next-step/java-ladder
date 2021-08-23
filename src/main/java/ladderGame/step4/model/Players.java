package ladderGame.step4.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {

  public static final String MSG_ERROR_LIMIT_PLAYERS = "플레이어는 최소 2명이상이여야 합니다.";

  private static final String SPLIT_MARK = ",";

  private static final int LIMIT_PLAYER_COUNT = 2;

  private final List<PlayerName> playerNames;

  public Players(final List<PlayerName> playerNames) {
    validationPlayersCount(playerNames);
    this.playerNames = Collections.unmodifiableList(playerNames);
  }

  public static List<PlayerName> of(final String playerNames) {
    return splitNames(playerNames)
        .stream()
        .map(PlayerName::new)
        .collect(Collectors.toList());
  }

  public List<String> playersName(){
    return playerNames
        .stream()
        .map(PlayerName::writeName)
        .collect(Collectors.toList());
  }

  public int count(){
    return playerNames.size();
  }

  public int findIndexByName(String playerName) {
    return playerNames.indexOf(new PlayerName(playerName));
  }

  private void validationPlayersCount(final List<PlayerName> players) {
    if (players.size() < LIMIT_PLAYER_COUNT) {
      throw new IllegalArgumentException(MSG_ERROR_LIMIT_PLAYERS);
    }
  }

  private static List<String> splitNames(final String players) {
    return Arrays.asList(players.split(SPLIT_MARK));
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Players players = (Players) o;
    return Objects.equals(playerNames, players.playerNames);
  }

  @Override
  public int hashCode() {
    return Objects.hash(playerNames);
  }
}