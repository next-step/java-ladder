package ladder.domain.pointer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.Ladder;
import ladder.domain.line.Line;
import ladder.domain.moving.MovingStrategy;
import ladder.domain.name.Names;
import ladder.domain.position.Position;

public class Pointers {

    private final List<Pointer> pointers;

    public Pointers(List<Pointer> pointers) {
        this.pointers = pointers;
    }

    public static Pointers of(Names names) {
        return new Pointers(IntStream.range(0, names.names().size())
            .mapToObj(i -> Pointer.of(names.names().get(i), Position.of(0, i)))
            .collect(Collectors.toList()));
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
        List<Pointer> pointerList = new ArrayList<>(pointers);
        for (Line line : ladder.lines()) {
            pointerList = nextPointerList(movingStrategy, pointerList, line);
        }
        return new Pointers(pointerList);
    }

    public List<Pointer> pointers() {
        return List.copyOf(pointers);
    }

    private List<Pointer> nextPointerList(MovingStrategy movingStrategy, List<Pointer> pointerList, Line line) {
        return pointerList.stream()
            .map(pointer -> pointer.move(movingStrategy.nextMoving(line, pointer.position().width())))
            .collect(Collectors.toList());
    }

}
