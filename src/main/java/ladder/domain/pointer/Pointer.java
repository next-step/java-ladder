package ladder.domain.pointer;

import java.util.Objects;
import ladder.domain.moving.Moving;
import ladder.domain.name.Name;
import ladder.domain.position.Position;

public class Pointer {

    private final Name name;
    private final Position position;

    public Pointer(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Pointer of(Name name, Position position) {
        return new Pointer(name, position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pointer pointer = (Pointer) o;
        return Objects.equals(name, pointer.name) && Objects.equals(position,
            pointer.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Pointer{" +
            "name=" + name +
            ", position=" + position +
            '}';
    }

    public Pointer move(Moving moving) {
        return new Pointer(name, position.move((x,y) -> moving, null));
    }

    public Name name() {
        return name.clone();
    }

    public Position position() {
        return position.clone();
    }

}
