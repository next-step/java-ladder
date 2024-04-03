package ladder.domain;

import ladder.dto.LaddersDto;
import ladder.dto.PlayerDto;
import ladder.dto.PrizeDto;

import java.util.ArrayList;
import java.util.List;

public class StatusDto {
  private final List<PlayerDto> players;
  private final LaddersDto ladders;
  private final List<PrizeDto> prizes;

  public StatusDto(final Players players, final Ladders ladders, final List<Prize> prizes) {
    this.players = new ArrayList<>();
    for (Player player : players) {
      this.players.add(new PlayerDto(player));
    }

    this.ladders = new LaddersDto(ladders);

    this.prizes = new ArrayList<>();
    for (Prize prize : prizes) {
      this.prizes.add(new PrizeDto(prize));
    }
  }

  public List<PlayerDto> getPlayers() {
    return this.players;
  }

  public LaddersDto getLadders() {
    return this.ladders;
  }

  public List<PrizeDto> getPrizes() {
    return this.prizes;
  }
}
