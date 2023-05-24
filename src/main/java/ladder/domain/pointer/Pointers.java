package ladder.domain.pointer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import ladder.domain.Ladder;
import ladder.domain.line.Line;
import ladder.domain.moving.MovingStrategy;
import ladder.domain.name.Name;
import ladder.domain.name.Names;
import ladder.domain.position.Position;

public class Pointers {

    private final List<Pointer> pointers;

    public Pointers(List<Pointer> pointers) {
        this.pointers = pointers;
    }

    public static Pointers of(Names names) {
        List<Pointer> pointers = new ArrayList<>();
        List<Name> nameList = names.names();
        for (int i = 0; i < nameList.size(); i++) {
            pointers.add(Pointer.of(nameList.get(i), Position.of(0, i)));
        }
        return new Pointers(pointers);
    }

    public static Pointers of(List<Pointer> pointers) {
        return new Pointers(pointers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pointers pointers1 = (Pointers) o;
        return Objects.equals(pointers, pointers1.pointers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointers);
    }

    @Override
    public String toString() {
        return "Pointers{" +
            "pointers=" + pointers +
            '}';
    }

    public Pointers destinationOf(MovingStrategy movingStrategy, Ladder ladder) {
        List<Pointer> ret = new ArrayList<>(pointers);
        for (Line line : ladder.lines()) {
            for (int i = 0; i < ret.size(); i++) {
                ret.set(i, ret.get(i).move(movingStrategy.nextMoving(line, ret.get(i).position().width())));
            }
        }
        return new Pointers(ret);
    }

    public List<Pointer> pointers() {
        return List.copyOf(pointers);
    }

}
