package laddergameRDD.domain;

import java.util.Objects;

public class GameResult {
    private final String name;
    private final String result;

    public GameResult(String name, String result) {
        this.name = name;
        this.result = result;
    }

    public String getUserName() {
        return name;
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(name, that.name) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, result);
    }
}
