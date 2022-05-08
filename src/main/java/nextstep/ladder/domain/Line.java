package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Line {

    protected List<LinePart> parts;
    protected Name name;

    protected Line(String name, int height) {
        this.parts = new ArrayList<>();
        for (int i = 0; i < height; ++i) {
            parts.add(new LinePart());
        }

        this.name = new Name(name);
    }

    public static Line of(String name, int height) {
        return new Line(name, height);
    }

    public int connectOne() {
        int index = new Random().nextInt(parts.size());

        parts.get(index).connect();

        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(parts, line.parts) && Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parts, name);
    }

    @Override
    public String toString() {
        return "\n{" + parts + name + '}';
    }

    public int getPartCount() {
        return parts.size();
    }

    public List<LinePart> getParts() {
        return parts;
    }

    public int getHeight() {
        return parts.size();
    }

    public String getName() {
        return name.get();
    }

    public void connect(int connectedIndex) {
        parts.get(connectedIndex).connect();
    }

    public boolean hasConnected() {
        return parts.stream()
            .anyMatch(LinePart::isConnected);
    }
}
