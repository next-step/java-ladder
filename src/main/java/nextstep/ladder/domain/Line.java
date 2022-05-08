package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Line {

    private List<LinePart> parts;
    private Name name;

    private Line(String name, int height, int index) {
        this.parts = new ArrayList<>();
        for (int i = 0; i < height; ++i) {
            parts.add(new LinePart());
        }

        this.name = new Name(name);
    }

    public static Line of(String name, int height, int index) {
        return new Line(name, height, index);
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

    public LinePart getLinePart(int linePartIndex) {
        return parts.get(linePartIndex);
    }
    public List<LinePart> getParts() {
        return parts;
    }

    public int partsSize() {
        return parts.size();
    }

    public int getHeight() {
        return parts.size();
    }

    public String getName() {
        return name.get();
    }

    public void connect(int connectedIndex) {
        if (parts.size() <= connectedIndex)
            throw new IllegalStateException("연결 불가한 LinePart 의 인덱스 값");

        parts.get(connectedIndex).connect();
    }

    public boolean hasConnected() {
        return parts.stream()
            .anyMatch(LinePart::isConnected);
    }

    public void connectFirst() {
        connect(0);
    }

    public void connectSecond() {
        connect(1);
    }

}
