package ladder.dto;

import ladder.domain.Player;

import java.util.Objects;

public class PlayerDto {
  private String name;

  public PlayerDto(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    PlayerDto playerDto = (PlayerDto) o;
    return name.equals(playerDto.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
