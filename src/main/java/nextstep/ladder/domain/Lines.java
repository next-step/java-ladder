package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import nextstep.ladder.generator.NonConsecutiveFlagGenerator;

public class Lines {

    private final List<Boolean> lines;

    public Lines(NonConsecutiveFlagGenerator nonConsecutiveFlagGenerator) {
        this.lines = nonConsecutiveFlagGenerator.create();
    }

    public List<Boolean> getPoint() {
        return Collections.unmodifiableList(lines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
