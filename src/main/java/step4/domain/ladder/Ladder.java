package step4.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;
import step4.domain.user.User;
import step4.domain.user.Users;
import step4.strategy.DirectionGenerateStrategy;

public class Ladder {

    private static final int START_LADDER_INDEX = 0;

    private final List<LadderLine> ladderLines;

    private Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    static Ladder of(List<LadderLine> ladderLines) {
        return new Ladder(ladderLines);
    }

    public static Ladder createLadder(LadderHeight height, Users users, DirectionGenerateStrategy strategy) {
        List<LadderLine> lines = new ArrayList<>();
        IntStream.range(START_LADDER_INDEX, height.value())
            .forEach(index -> lines.add(LadderLine.createLine(users, strategy)));
        return new Ladder(lines);
    }

    public LadderResult createResult(Users users, LadderEndPoints endPoints) {
        Map<User, String> results = new HashMap<>();

        IntStream.range(START_LADDER_INDEX, users.usersCount())
            .forEach(position -> {
                User user = users.userByPosition(position);
                int userResultPosition = calculateEndPoint(position);
                String endPoint = endPoints.endPointByPosition(userResultPosition);
                results.put(user, endPoint);
            });

        return LadderResult.of(results);
    }

    private int calculateEndPoint(int start) {
        int now = start;
        for (LadderLine line : ladderLines) {
            now = line.move(now);
        }
        return now;
    }

    public List<LadderLine> values() {
        return Collections.unmodifiableList(ladderLines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladder ladder = (Ladder) o;
        return Objects.equals(ladderLines, ladder.ladderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderLines);
    }
}
