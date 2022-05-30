package nextstep.ladder.domain.line;

import nextstep.ladder.domain.member.Member;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lines {
    private static final String DELIMITER = "";

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public String getPoints() {
        return this.lines.stream()
                .map(Line::getPoint)
                .collect(Collectors.joining(DELIMITER));
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

    public void move(Member member) {
        this.lines.forEach(line -> line.move(member));
    }
}
