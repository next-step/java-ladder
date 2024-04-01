package ladder.domain;

import ladder.dto.LaddersDto;
import ladder.dto.PlayerDto;

import java.util.ArrayList;
import java.util.List;

public class ResultDto {
  private final List<PlayerDto> players;
  private final LaddersDto ladders;

  public ResultDto(Players players, Ladders ladders) {
    this.players = new ArrayList<>();
    for (Player player : players) {
      this.players.add(new PlayerDto(player));
    }
    this.ladders = new LaddersDto(ladders);
  }

  public List<PlayerDto> getPlayers() {
    return this.players;
  }

  public LaddersDto getLadders() {
    return this.ladders;
  }
}
