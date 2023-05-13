package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final Users users;
    private final List<LadderRow> ladderRows;

    public Ladder(Users users, List<LadderRow> ladderRows) {
        this.users = users;
        this.ladderRows = ladderRows;
    }

    public static Ladder of(Users users, Height height, DrawStrategy drawStrategy) {
        List<LadderRow> ladderRows = IntStream.range(0, height.getHeight())
                .mapToObj(i -> LadderRow.of(users.numberOfUsers(), drawStrategy))
                .collect(Collectors.toList());
        return new Ladder(users, ladderRows);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(ladderRows, ladder.ladderRows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderRows);
    }
}
