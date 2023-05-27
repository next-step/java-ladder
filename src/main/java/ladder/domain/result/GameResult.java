package ladder.domain.result;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import ladder.domain.Ladder;
import ladder.domain.name.Name;
import ladder.domain.name.Names;
import ladder.domain.pointer.Pointer;
import ladder.domain.pointer.Pointers;
import ladder.domain.position.Position;
import ladder.domain.moving.MovingStrategy;

public class GameResult {

    private final Map<Name, Position> result;

    public GameResult(Map<Name, Position> result) {
        this.result = result;
    }

    public static GameResult of(MovingStrategy movingStrategy, Names names, Ladder ladder) {
        Pointers pointers = Pointers.of(names).destinationOf(movingStrategy, ladder);
        Map<Name, Position> ret = new HashMap<>();
        for (Pointer pointer : pointers.pointers()) {
            ret.put(pointer.name(), pointer.position());
        }
        return new GameResult(ret);
    }

    public static GameResult of(Map<Name, Position> result) {
        return new GameResult(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameResult that = (GameResult) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return "GameResult{" +
            "result=" + result +
            '}';
    }

    public int resultOf(Name name) {
        return result.get(name).width();
    }

}
