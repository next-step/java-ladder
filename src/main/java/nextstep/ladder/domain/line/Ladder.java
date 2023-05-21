package nextstep.ladder.domain.line;

import nextstep.ladder.domain.line.generator.LineGenerator;
import nextstep.ladder.domain.user.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(LineGenerator lineGenerator, LadderHeight ladderHeight, Users users) {
        ladderHeight.toStream()
                .forEach(i -> lines.add(new Line(lineGenerator, users.userCount())));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.lines.getClass() != o.getClass()) return false;
        List<Line> otherLines = (List<Line>) o;
        if (lines.size() != otherLines.size()) return false;
        for (int i = 0; i < lines.size(); i++) {
            if (!lines.get(i).equals(otherLines.get(i))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    public boolean hasLine(int height, int width) {
        return this.lines.get(height).hasLine(width);
    }
}
