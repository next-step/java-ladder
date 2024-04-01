package ladder.dto;

import ladder.domain.Player;

public class PlayerDto {
  private String name;

  public PlayerDto(Player player) {
    this.name = player.name();
  }

  public String getName() {
    return this.name;
  }
}
