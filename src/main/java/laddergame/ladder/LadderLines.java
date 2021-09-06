package laddergame.ladder;

import laddergame.connectable.Connection;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLines {
    private final List<LadderLine> lines;

    //TODO: 테스트 코드에서만 쓸 경우 삭제 (리팩토링 과정에서 생김)
    public LadderLines(List<LadderLine> lines) {
        this.lines = lines;
    }

    //TODO: 테스트 코드에서만 쓸 경우 삭제 (리팩토링 과정에서 생김)
    public LadderLines(Height height) {
        this.lines = IntStream.range(0, height.value())
                .mapToObj(LadderLine::new)
                .collect(Collectors.toList());
    }

    public LadderLines(Height height, int countOfPerson, Connection connection) {
        this.lines = IntStream.range(0, height.value())
                .mapToObj(i -> new LadderLine(countOfPerson, connection))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLines that = (LadderLines) o;
        return Objects.equals(lines, that.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    public List<LadderLine> value() {
        return this.lines;
    }
}
