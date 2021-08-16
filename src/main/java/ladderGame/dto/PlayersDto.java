package ladderGame.dto;

import java.util.Collections;
import java.util.List;
import ladderGame.model.Player;
import ladderGame.model.Players;

public class PlayersDto {

  private final List<Player> players;

  private PlayersDto(final Players players) {
    this.players = Collections.unmodifiableList(players.toList());
  }

  public static PlayersDto of(final Players players){
    return new PlayersDto(players);
  }

  public List<Player> values(){
    return players;
  }
}