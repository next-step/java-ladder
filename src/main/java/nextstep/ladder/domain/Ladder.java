package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import nextstep.ladder.generator.NonConsecutiveFlagGenerator;

public class Ladder {

    private final List<Lines> ladder;

    public Ladder(List<Lines> ladder) {
        if (ladder.isEmpty()) {
            throw new IllegalArgumentException("사다리의 높이는 0이하 일 수 없습니다.");
        }
        this.ladder = ladder;
    }

    public Ladder(int height, NonConsecutiveFlagGenerator generator) {
        this(toLadder(height, generator));
    }

    private static List<Lines> toLadder(int height, NonConsecutiveFlagGenerator generator) {
        return Stream.generate(() -> new Lines(generator)).limit(height).collect(Collectors.toList());
    }

    public List<Lines> getLines() {
        return Collections.unmodifiableList(ladder);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladder ladder1 = (Ladder) o;
        return Objects.equals(ladder, ladder1.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder);
    }
}
