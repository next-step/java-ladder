package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import nextstep.ladder.generator.GeneratorWidthSize;
import nextstep.ladder.generator.NonConsecutiveFlagGenerator;

public class Ladder {

    private final List<Lines> ladder;
    private LadderWidth width;

    public Ladder(int width, List<Lines> ladder) {
        if (ladder.isEmpty()) {
            throw new IllegalArgumentException("사다리의 높이는 0이하 일 수 없습니다.");
        }
        this.width = new LadderWidth(width);
        this.ladder = List.copyOf(ladder);
    }

    public Ladder(int height, int width, NonConsecutiveFlagGenerator generator) {
        this(width, LadderConverter.convert(height, width, generator));
    }

    public List<Lines> getLines() {
        return ladder;
    }

    public Position result() {
        Position result = position();
        moveAll(result);
        return result;
    }

    private Position position() {
        return width.position();
    }

    private void moveAll(Position position) {
        for (Lines lines : ladder) {
            lines.move(position);
        }
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

    private static class LadderConverter {
        private static List<Lines> convert(int height, int width, NonConsecutiveFlagGenerator generator) {
            return toLadder(height, width, generator);
        }

        private static List<Lines> toLadder(int height, int width, NonConsecutiveFlagGenerator generator) {
            return Stream.generate(() -> new Lines(generator.create(new GeneratorWidthSize(width - 1)))).limit(height)
                    .collect(Collectors.toList());
        }
    }
}
