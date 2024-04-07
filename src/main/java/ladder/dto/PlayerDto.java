package ladder.dto;

import ladder.domain.Player;

public class PlayerDto {
  private String name;

  public PlayerDto(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}
