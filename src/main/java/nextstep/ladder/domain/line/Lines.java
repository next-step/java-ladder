package nextstep.ladder.domain.line;

import nextstep.ladder.domain.edge.LadderUsers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {
    private final List<Line> value;

    public Lines(int width, Height height, LineFactory lineFactory) {
        this.value = Stream.generate(() -> lineFactory.create(width))
            .limit(height.getValue())
            .collect(Collectors.toList());
    }

    public int size() {
        return value.size();
    }

    public List<List<Boolean>> getvalue() {
        return value.stream().map(Line::getValue).collect(Collectors.toList());
    }

    public LadderUsers moveUsers(LadderUsers users) {
        LadderUsers res = users;
        for (Line line : value) {
            res = res.move(line);
        }
        return res;
    }

    @Override
    public String toString() {
        return "Lines{" +
            "value=" + value +
            '}';
    }
}
