package ladder.dto;

import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Prize;
import ladder.dto.LadderDto;
import ladder.dto.PlayerDto;
import ladder.dto.PrizeDto;

import java.util.ArrayList;
import java.util.List;

public class StatusDto {
  private final List<PlayerDto> players;
  private final LadderDto ladder;
  private final List<PrizeDto> prizes;

  public StatusDto(final Players players, final Ladder ladder, final List<Prize> prizes) {
    this.players = new ArrayList<>();
    for (Player player : players) {
      this.players.add(new PlayerDto(player));
    }

    this.ladder = new LadderDto(ladder);

    this.prizes = new ArrayList<>();
    for (Prize prize : prizes) {
      this.prizes.add(new PrizeDto(prize));
    }
  }

  public List<PlayerDto> getPlayers() {
    return this.players;
  }

  public LadderDto getladder() {
    return this.ladder;
  }

  public List<PrizeDto> getPrizes() {
    return this.prizes;
  }
}
