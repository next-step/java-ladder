package ladder.dto;

import ladder.domain.Ladder;
import java.util.ArrayList;
import java.util.List;

public class StatusDto {
  private final List<PlayerDto> players;
  private final LadderDto ladder;
  private final List<PrizeDto> prizes;

  public StatusDto(final List<String> names, final Ladder ladder, final List<String> prizeValues) {
    this.players = new ArrayList<>();
    for (String name : names) {
      this.players.add(new PlayerDto(name));
    }

    this.ladder = new LadderDto(ladder);

    this.prizes = new ArrayList<>();
    for (String value : prizeValues) {
      this.prizes.add(new PrizeDto(value));
    }
  }

  public List<PlayerDto> getPlayers() {
    return this.players;
  }

  public LadderDto getLadder() {
    return this.ladder;
  }

  public List<PrizeDto> getPrizes() {
    return this.prizes;
  }
}
