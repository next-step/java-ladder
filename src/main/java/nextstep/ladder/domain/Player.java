package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import nextstep.ladder.exception.LadderExceptionCode;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Player {
    private static final int MAX_LENGTH = 5;
    private final String name;
    private final Coordinate coordinate;
    private String result;

    public Player(String name) {
        this(name, Coordinate.of(0, 0), "");
    }

    public Player(String name, Coordinate coordinate) {
        this(name, coordinate, "");
    }

    public Player(String name, Coordinate coordinate, String result) {
        validate(name);
        this.name = name;
        this.coordinate = coordinate;
        this.result = result;
    }

    private void validate(String name) {
        if (isEmpty(name)) {
            throw new LadderException(LadderExceptionCode.INVALID_NAME_FORMAT, name);
        }

        if (name.length() > MAX_LENGTH) {
            throw new LadderException(LadderExceptionCode.INVAILD_NAME_LENGTH, String.valueOf(name.length()));
        }
    }

    private boolean isEmpty(String name) {
        return name == null || name.isBlank();
    }

    public void move(List<Line> lines, Height height, List<String> results) {
        IntStream.range(0, height.getHeight())
                .forEach(index -> coordinate.move(lines));

        result = matchResult(lines, results);
    }

    private String matchResult(List<Line> lines, List<String> results) {
        if (coordinate.done(lines.size())) {
            return results.get(coordinate.x());
        }
        throw new LadderException(LadderExceptionCode.INVALID_GAME_EXIT);
    }

    public boolean equalName(String name) {
        return this.name.equals(name);
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
        Player player = (Player) o;
        return Objects.equals(getName(), player.getName()) && Objects.equals(coordinate, player.coordinate) && Objects.equals(result, player.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), coordinate, result);
    }
}
