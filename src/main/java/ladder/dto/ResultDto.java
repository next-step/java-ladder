package ladder.dto;

import ladder.domain.Player;

import java.util.Objects;

public class ResultDto {
    private Player player;
    private String result;

    public ResultDto(Player player, String result) {
        this.player = player;
        this.result = result;
    }

    public ResultDto(String name, String result) {
        this.player = new Player(name);
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultDto resultDto = (ResultDto) o;
        return Objects.equals(player, resultDto.player) &&
                Objects.equals(result, resultDto.result);
    }

    public Player getPlayer() {
        return player;
    }

    public String getResult() {
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, result);
    }

    @Override
    public String toString() {
        return player + " = " + result;
    }
}
