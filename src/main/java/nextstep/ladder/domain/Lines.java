package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Lines {

    private final List<Boolean> lines;

    public Lines(NonConsecutiveFlagGenerator nonConsecutiveFlagGenerator) {
        this.lines = nonConsecutiveFlagGenerator.create();
    }

    public Lines(List<Boolean> lines) {
        this(createDefaultGenerator(lines));
    }

    private static NonConsecutiveFlagGenerator createDefaultGenerator(List<Boolean> lines) {
        return new NonConsecutiveFlagGenerator() {
            @Override
            protected List<Boolean> createResult() {
                return lines;
            }
        };
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
