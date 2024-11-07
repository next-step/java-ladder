package nextstep.laddergame.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lines {
    private final List<Boolean> lines;

    public Lines(List<Boolean> lines) {
        this.lines = lines;
    }

    public Lines(Boolean... lines) {
        this.lines = Arrays.asList(lines);
    }

    public static Lines empty(int height) {
        return new Lines(Collections.nCopies(height, Boolean.FALSE));
    }

    public int size() {
        return this.lines.size();
    }

    public boolean isAlreadySetAt(int floor) {
        return Boolean.TRUE.equals(lines.get(floor));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
