package ladder.dto;

import java.util.Objects;

public class GameResultDto {
    private final String name;
    private final String result;

    public GameResultDto(String name, String result) {
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResultDto that = (GameResultDto) o;
        return Objects.equals(name, that.name) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, result);
    }
}
