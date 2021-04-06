package step4_ladderGame.dto;

import laddarGame.domain.PlayerName;
import laddarGame.domain.Position;

import java.util.Objects;

public class PlayerDto {

    private final String name;
    private final int position;

    public PlayerDto(PlayerName name, Position position) {
        this.name = name.name();
        this.position = position.position();
    }

    public PlayerDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getNameLength() {
        return name.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerDto playerDto = (PlayerDto) o;
        return position == playerDto.position && Objects.equals(name, playerDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
