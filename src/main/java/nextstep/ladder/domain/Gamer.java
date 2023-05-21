package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Gamer {
    private final Name name;
    private final Position position;

    public Gamer(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Gamer of(String name, int position) {
        return new Gamer(Name.from(name), Position.from(position));
    }

    public Gamer climb(Ladder ladder) {
        return new Gamer(name, ladder.move(position));
    }

    public Result match(List<String> executionResult) {
        return Result.from(executionResult.get(position.toInt()));
    }

    public String getName() {
        return name.toString();
    }

    public int getPosition() {
        return position.toInt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gamer gamer = (Gamer) o;
        return Objects.equals(name, gamer.name) && Objects.equals(position, gamer.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
