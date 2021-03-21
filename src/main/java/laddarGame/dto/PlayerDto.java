package laddarGame.dto;

import laddarGame.domain.Name;
import laddarGame.domain.Position;

import java.util.Objects;

public class PlayerDto {

    private String name;
    private int position;

    public PlayerDto(Name name, Position position) {
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

    public int getPosition() {
        return position;
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
