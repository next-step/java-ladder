package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import nextstep.ladder.interfaces.Ladder;
import nextstep.ladder.interfaces.Lines;
import nextstep.ladder.interfaces.Position;

public class LadderImpl implements Ladder {

    private final List<Lines> ladder;
    private final LadderWidth width;

    public LadderImpl(LadderWidth ladderWidth, List<Lines> ladder) {
        if (ladder.isEmpty()) {
            throw new IllegalArgumentException("사다리의 높이는 0이하 일 수 없습니다.");
        }
        this.width = ladderWidth;
        this.ladder = List.copyOf(ladder);
    }

    public LadderImpl(int width, List<Lines> ladder) {
        this(new LadderWidth(width), ladder);
    }

    @Override
    public List<Lines> getLines() {
        return ladder;
    }

    @Override
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
        LadderImpl ladder1 = (LadderImpl) o;
        return Objects.equals(ladder, ladder1.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder);
    }

}
